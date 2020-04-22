import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;  
import java.util.*;

public class TommyServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
        res.setContentType("text/html");//setting the content type  
		PrintWriter pw=res.getWriter();//get the stream to write the data
		//writing html in the stream  
		pw.println("<html><body>");  
		pw.println("<h1>Welcome to servlet</h1>");  
		
		pw.println("<h2>Request information</h2>");
		pw.println("<table>");
		pw.println("<tr><td>AuthType</td><td>" + req.getAuthType() + "</td></tr>");
		pw.println("<tr><td>Context Path</td><td>" + req.getContextPath() + "</td></tr>");
		
		// Cookies from request
		Cookie[] cookies = req.getCookies();  
        if (cookies != null) {   
            for (Cookie cookie : cookies) {   
                pw.println("<tr><td>Cookie " + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
			}
		}
		else {
			pw.println("<tr><td>No cookies</td><td> </td></tr>");
		}
		
        // Header from request
	    Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = req.getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
				pw.println("<tr><td>Header: " + headerName + "</td><td>" + headerValue + "</td></tr>");
            }
        }
		
		pw.println("<tr><td>HTTP method</td><td>" + req.getMethod() + "</td></tr>");
		pw.println("<tr><td>Query string</td><td>" + req.getQueryString() + "</td></tr>");
		

		pw.println("</table>");
		
		pw.println("</body></html>");  
		pw.close();//closing the stream
	}
}  
