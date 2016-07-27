package request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 通过表单收集客户端数据
@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test1(request);
		
	}

	private void test1(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");	//现在对POST和GET均有效
		
		// 传统方法改正GET乱码问题
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"), "UTF-8");
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("city"));
		String[] likes = request.getParameterValues("likes");
		for (int i = 0; likes != null && i < likes.length; i++) {
			System.out.println(likes[i]);
		}
		System.out.println(request.getParameter("Remarks"));
		//file => inputStream()
		System.out.println(request.getParameter("id"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
