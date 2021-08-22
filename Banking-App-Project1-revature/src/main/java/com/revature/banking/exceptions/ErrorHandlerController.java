package com.revature.banking.exceptions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandlerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ErrorHandlerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myCustomProcessError(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myCustomProcessError(request, response);
	}
	
	private void myCustomProcessError(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head><title>Exception/Error Details</title></head><body>");
		if (statusCode != 500) {
			out.write("<h3>Error Details</h3>");
			out.write("<strong><font color=red>Status Code</strong>:" + statusCode + "<br>");
			out.write("<strong><font color=red>Requested URI</strong>:" + requestUri);
		} else {
			out.write("<h3><font color=red>Exception Details</h3>");
			out.write("<ul><font color=red><li>Servlet Name:" + servletName + "</li>");
			out.write("<li><font color=red>Exception Name:" + throwable.getClass().getName() + "</li>");
			out.write("<li><font color=red>Requested URI:" + requestUri + "</li>");
			out.write("<li><font color=red>Exception Message:" + throwable.getMessage() + "</li>");
			out.write("</ul>");
		}

		out.write("<br><br>");
		out.write("<a href=\"Welcome.html\">Home Page</a>");
		out.write("</body></html>");
	}
}
