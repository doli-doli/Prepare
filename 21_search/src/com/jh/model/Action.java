package com.jh.model;

import javax.servlet.http.HttpServletRequest;

public interface Action {
	public String process(HttpServletRequest request);
}
