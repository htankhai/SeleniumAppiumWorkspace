package com.xmlServlet;
//Url parameter as input and output to the printerWriter
//submit query form with Post method
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlServlet
 */

public class XmlServletQuery extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Xml Servlet in Web Application is applied");
		response.setContentType("text/html");
		PrintWriter  pWriter = response.getWriter();
		//in Url parameter input request as parameter and printed output form response 
		String userName= request.getParameter("username");
		pWriter.println("to User" + userName);
		
	}
	
	
	//input request tyype into the submit query form and get the output response on printed
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Xml Servlet in Web Application is applied");
		response.setContentType("text/html");
		PrintWriter  pWriter = response.getWriter();
		//input request as parameter and print to output form response in Url parameter
		String userName= request.getParameter("username");
		pWriter.println("to User" + userName);
		
	}
		

}
