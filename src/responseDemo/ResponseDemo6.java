package responseDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ¿ØÖÆä¯ÀÀÆ÷»º´æ
@WebServlet("/ResponseDemo6")
public class ResponseDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		response.setDateHeader("expires", System.currentTimeMillis() + 1000*3600);
   		String data = "aaa";
   		response.getWriter().write(data);
	}
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
