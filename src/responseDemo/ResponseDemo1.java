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
		// ����������ĳ�����ʽ
		response.setHeader("Content-type", "text/html;charset=UTF-8");
				
		String data = "�л����񹲺͹�";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}
	
	private void test2(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// ��<mata>��ǩ������
		String data = "�л����񹲺͹�";
		OutputStream out = response.getOutputStream();
		
		out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	
	private void test3(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// ����д���ˣ����������
		response.setHeader("Content-type", "text/html,charset=UTF-8");
				
		String data = "�л����񹲺͹�";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}

}
