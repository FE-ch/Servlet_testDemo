package responseDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test1(response);
//		test2(response);
//		test3(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void test1(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// 操纵浏览器的呈现形式
		response.setHeader("Content-type", "text/html;charset=UTF-8");
				
		String data = "中华人民共和国";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}
	
	private void test2(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// 用<mata>标签来控制
		String data = "中华人民共和国";
		OutputStream out = response.getOutputStream();
		
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	
	private void test3(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// 这里写错了，变成了下载
		response.setHeader("Content-type", "text/html,charset=UTF-8");
				
		String data = "中华人民共和国";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}

}
