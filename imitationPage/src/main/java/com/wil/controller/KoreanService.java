package com.wil.controller;

import javax.inject.Inject;

public class KoreanService {
	
	@Inject
	private String str;

	public String greet(){
		return this.str+"Korean Hello";
	}
}
