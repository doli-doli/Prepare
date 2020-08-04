package com.jh.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jh.dao.EmployeeDao;
import com.jh.dto.EmployeeDto;

public class DeptListAction implements Action {

	@Override
	public String process(HttpServletRequest request) {
		
		String department_id = request.getParameter("department_id");
		
		if( department_id == null || department_id.isEmpty() ) {
			department_id = "10";
		} 
		
		List<EmployeeDto> list = EmployeeDao.getEmployeeByDept(Integer.parseInt(department_id));
		
		request.setAttribute("list",list);
		
		return "deptList.jsp";
	}

}
