package com.accenture.lkm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet1
 */
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		// getting session object created by container
		HttpSession session=request.getSession();
		
		//retrieving and printing the session Id created 
		out.print("session Id :- " + session.getId() );
		
		
		
		String userName=request.getParameter("uname");
						
		if(userName==null || userName.equals("")){
			out.print("<center><h3><font color='red'> User Name is mandatory, pls provide user Name </font></h3></center>");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);
		}else{
			out.print("<h2> Page1 welcomes <font color='Green'>"+ userName +"</font></h2>");
			out.print("<br>");
			
			// storing information to session object(1st parameter is always a string and 2nd parameter can be any object)
			session.setAttribute("sessionVariable",userName);
			
		
			// while clicking on this hyper link make a new request for SessionServlet2 but client is sending request in same session
			out.println("<a href='SessionServlet2'> Next Page </a>"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
