package responseDemo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 控制浏览器定时刷新
@WebServlet("/ResponseDemo5")
public class ResponseDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test3(request, response);
	}

	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 假设用于处理登录的servlet
		
		// 假设程序运行到此，用户成功
		String message = "<meta http-equiv='refresh' content='3;url=/Servlet_testDemo/index.jsp'>登陆成功，即将在3s内跳转，如果没有跳转，请点击<a href=''>link</a>";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/Servlet_testDemo/message.jsp").forward(request, response);
	}

	
	// 不用这种方法
	private void test2(HttpServletResponse response) throws IOException {
		// 假设用于处理登录的servlet
		
		// 假设程序运行到此，用户成功
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='/Servlet_testDemo/NewFile.jsp'");
		response.getWriter().write("登陆成功，即将在3s内跳转，如果没有跳转，请点击<a href=''>link</a>");
	}
	
	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "2");
		
		String data = new Random().nextInt(100000) + "";
		response.getWriter().write(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
