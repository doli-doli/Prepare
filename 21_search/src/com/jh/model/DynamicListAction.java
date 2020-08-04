package com.jh.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jh.dao.EmployeeDao;
import com.jh.dto.EmployeeDto;

public class DynamicListAction implements Action {

	@Override
	public String process(HttpServletRequest request) {
		
		String path = null;
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		if( value == null || value.isEmpty()) {				// 아무것도 입력하지 않으면
			path = "input_dynamic.jsp";						// 입력화면으로 가자!
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("key", key);
			map.put("value", value);						// 데이터의 이동경로 : dao -> map -> mapper
			List<EmployeeDto> list = EmployeeDao.getEmployeeByDynamic(map);
			request.setAttribute("list", list);
			request.setAttribute("key", key);
			path = "dynamicList.jsp";
		}
		
		return path;
	}

}
