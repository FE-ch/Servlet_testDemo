package responseDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 设置response 使用的码表，以控制response以什么码表向浏览器写数据
//		response.setCharacterEncoding("UTF-8");
		
		// 指定浏览器以什么码表打开服务器发送的数据
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		// 一种简便办法
		response.setContentType("text/html;charset=UTF-8");
		
		String data = "学习粉丝团";
		PrintWriter out = response.getWriter();
		out.write(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
