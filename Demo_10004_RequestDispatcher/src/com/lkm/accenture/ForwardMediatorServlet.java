package com.lkm.accenture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardMediatorServlet
 */
public class ForwardMediatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("age"));
		
		// print statment written below will not be displayed. Since the request is forwarded to another servlet the output will be the response of final servlet
		
		PrintWriter out=response.getWriter();
		out.print("Hello "+ userName);
		
		if(age>=60){
			RequestDispatcher rd=request.getRequestDispatcher("Senior");
			request.setAttribute("param",10);
			rd.forward(request, response);
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("Normal");
			rd.forward(request, response);
		}
		
		// Code written below will never get executed because the request will be dispatched using forward method 
		
		out.print("end of mediator servlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
