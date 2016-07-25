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
	
		// ����response ʹ�õ�����Կ���response��ʲô����������д����
//		response.setCharacterEncoding("UTF-8");
		
		// ָ���������ʲô���򿪷��������͵�����
//		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		// һ�ּ��취
		response.setContentType("text/html;charset=UTF-8");
		
		String data = "ѧϰ��˿��";
		PrintWriter out = response.getWriter();
		out.write(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
