package com.accenture.lkm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		// getting session object created by container
		HttpSession session=request.getSession();
				
		//retrieving and printing the session Id created.The sessionId printed will be as same as in the previous page
		out.print("session Id :- " + session.getId() );
		
		String userName=(String)session.getAttribute("sessionVariable"); // observe the parameter passed here
		
		// Here userName will be null. 
		//Since it made a new request object while clicking on the hyper link, the previous request object does not exists
		out.print("<h2> Page2 welcomes <font color='Green'> "+ userName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
