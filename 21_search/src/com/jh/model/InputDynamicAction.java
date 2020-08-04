package com.jh.model;

import javax.servlet.http.HttpServletRequest;

public class InputDynamicAction implements Action {

	@Override
	public String process(HttpServletRequest request) {
		// 단순 화면 이동
		return "input_dynamic.jsp";
	}

}
