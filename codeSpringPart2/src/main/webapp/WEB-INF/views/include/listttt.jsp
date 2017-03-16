<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="page" 	tagdir="/WEB-INF/tags/page"%>
<%@ taglib prefix="op" 		uri="/WEB-INF/tlds/functions" %>

<h3><span>출퇴근 내역</span></h3>

<form:form modelAttribute="param" action="" method="get">		
	<div class="board_write">
		<table class="board_write_table" summary="${ title }">
			<caption>${ title }</caption>
			<colgroup>
				<col style="width:150px;" />
				<col style="width:*;" />
				<col style="width:150px;" />
				<col style="width:*;" />
			</colgroup>
			<tbody>
				 <tr>
				 	<td class="label">검색구분</td>
				 	<td colspan="3">
				 		<div>
							<form:select path="where">
								<form:option value="COMMUTE_USER_NAME" label="이름" />
							</form:select> 
							<form:input path="query" class="input_txt required _filter" title="검색어" maxlength="20" />
						</div>
				 	</td>
				 </tr>
				 <tr>  
				 	<td class="label">일자</td> 
				 	<td colspan="3">
				 		<div>
							<span class="datepicker"><form:input path="commuteDateStart" class="datepicker" maxlength="8" title="시작일" /></span>
							<span class="wave">~</span>							
							<span class="datepicker"><form:input path="commuteDateEnd" class="datepicker" maxlength="8" title="종료일" /></span>
							<span class="day_btns"> 
								<a href="javascript:;" class="btn_date clear">전체</a>
								<a href="javascript:;" class="btn_date today">오늘</a> 
								<a href="javascript:;" class="btn_date week-1">1주일</a> 
								<a href="javascript:;" class="btn_date day-15">15일</a> 
								<a href="javascript:;" class="btn_date month-1">한달</a> 
								<a href="javascript:;" class="btn_date month-3">3개월</a> 
								<a href="javascript:;" class="btn_date year-1">1년</a>
							</span>
						</div> 
				 	</td>	
				 </tr>
				 <tr>
				 	<td class="label">출근 체크 여부</td> 
				 	<td>
				 		<div>
							<form:checkbox path="noCheckInSearchFlag" value="Y" label="출근 처리를 하지 않은 직원만 조회합니다." />
						</div> 
				 	</td>
				 	<td class="label">퇴사 여부</td> 
				 	<td>
				 		<div>
							<form:checkbox path="leaveSearchFlag" value="N" label="퇴사한 직원은 조회 대상에서 제외 합니다." />
						</div> 
				 	</td>
				 </tr>
			</tbody>					  
		</table>
									 							
	</div> <!-- // board_write -->  
	
	<!-- 버튼시작 -->	
	<div class="btn_all">
		<div class="btn_left">
			<a href="javascript:downloadExcel()" class="btn btn-success btn-sm">엑셀 다운로드</a>
			<button type="button" class="btn btn-dark-gray btn-sm" onclick="location.href='/opmanager/commute/list'"><span>초기화</span></button>
		</div> 
		<div class="btn_right">
			<button type="submit" class="btn btn-dark-gray btn-sm"><span>검색</span></button>
		</div>
	</div>		 
	<!-- 버튼 끝-->
</form:form>

<div class="board_list">
	<table class="board_list_table">
		<caption>출퇴근목록</caption>
		<colgroup>
			<col style="width:7%;">
			<col style="width:10%;">
			<col style="width:5%;">
			<col style="width:10%;">
			<col style="width:10%;">
			<col style="width:10%;">
			<col style="width:10%;">
			<col style="width:10%;">
			<col style="width:10%;">
		</colgroup>
		<thead>
			<tr>
				<th>일자</th>
				<th>이름</th>
				<th>근무시간</th>
				<th>출근시간</th>
				<th>출근기록</th>
				<th>지각사유</th>
				<th>퇴근시간</th>
				<th>퇴근기록</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${list}" var="list" varStatus="i">
				<tr>
					<td>${op:date(list.commuteDate)}</td>
					<td>
						${list.commuteUserName}
						<br />${list.commuteUserId}
					</td>
					<td>${list.workingTimeLabel}</td> 
					<td>
						${list.checkInDateLabel}
						<a href="javascript:editCommute('0', '${list.commuteDate}', '${list.encCommuteUserId}')" class="btn btn-dark-gray btn-sm">수정</a>
					</td>
					<td>${list.checkInStatusLabel}</td>
					<td>${list.checkInReason}</td>
					<td>
						${list.checkOutDateLabel}
						<a href="javascript:editCommute('1', '${list.commuteDate}', '${list.encCommuteUserId}')" class="btn btn-dark-gray btn-sm">수정</a>
					</td>
					<td>${list.checkOutStatusLabel}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${empty list}">
	<div class="no_content">
		데이터가 없습니다.
	</div>
	</c:if>
	
	<div class="btn_all">
		<div class="btn_left mb0">
		 	<a href="javascript:downloadExcel()" class="btn btn-success btn-sm">엑셀 다운로드</a>
		</div>
		<div class="btn_right mb0">
			
		</div>
	</div>
	
	<page:pagination/>	
</div>


<script type="text/javascript">
$(function(){
	Common.DateButtonEvent.set('.day_btns > a[class^=btn_date]', '', 'input[name="commuteDateStart"]' , 'input[name="commuteDateEnd"]');
});

function editCommute(commuteType, commuteDate, commuteUserId) {
	Common.popup('/opmanager/commute/form/'+ commuteType +'/'+ commuteDate +'/'+ commuteUserId, 'write', 450, 400, 1);
}

function downloadExcel() {
	Common.popup('/opmanager/commute/popup/excel-download', "excelPopup", 500, 600, 1);
}
</script>