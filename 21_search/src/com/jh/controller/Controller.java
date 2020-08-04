package com.jh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jh.model.Action;
import com.jh.model.AllListAction;
import com.jh.model.DeptListAction;
import com.jh.model.DynamicListAction;
import com.jh.model.InputDeptAction;
import com.jh.model.InputDynamicAction;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. request, response 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 파라미터 cmd 저장
		String paramCmd = request.getParameter("cmd");
		String cmd ="allList";
		if( paramCmd != null && !paramCmd.isEmpty() ) {
			cmd = paramCmd;
		}
		
		// 3. Action 인터페이스 선언
		Action action = null;		
		
		// 4. cmd 에 따른 model 선택
		switch( cmd ) {
		// 단순 화면 이동
		case "inputDept" : 
			action = new InputDeptAction();
			break;
		case "inputDynamic":
			action = new InputDynamicAction();
			break;
			
		// DB 사용 	
		case "allList" :
			action = new AllListAction();
			break;			
		case "deptList" :
			action = new DeptListAction();			
			break;			
		case "dynamicList" :
			action = new DynamicListAction();
			break;
		}
		
		// 5. 이동경로 path 알아내기
		String path = action.process(request);
		
		// 6. 이동하기
		request.getRequestDispatcher(path).forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
