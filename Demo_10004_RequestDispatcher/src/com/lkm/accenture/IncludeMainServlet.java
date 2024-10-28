package com.lkm.accenture;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncludeMainServlet
 */
public class IncludeMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.print("Main Servlet Service - Starts");
		
		String userName=request.getParameter("uname");
		double basicSalary=Double.parseDouble(request.getParameter("salary"));
		out.print("<h2>Basic Slary = "+ basicSalary +"</h2>");
		
		
		RequestDispatcher rd=request.getRequestDispatcher("Calculate");
		request.setAttribute("param",basicSalary);
		rd.include(request, response); // the response of the IncludeCalculateServlet will be placed here at run time
				
		// Code written below will also be displayed in the final output 
		
		out.print("Main Servlet Service - Ends");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
