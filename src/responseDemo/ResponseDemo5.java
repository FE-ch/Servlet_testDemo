package responseDemo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �����������ʱˢ��
@WebServlet("/ResponseDemo5")
public class ResponseDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		test3(request, response);
	}

	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �������ڴ����¼��servlet
		
		// ����������е��ˣ��û��ɹ�
		String message = "<meta http-equiv='refresh' content='3;url=/Servlet_testDemo/index.jsp'>��½�ɹ���������3s����ת�����û����ת������<a href=''>link</a>";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/Servlet_testDemo/message.jsp").forward(request, response);
	}

	
	// �������ַ���
	private void test2(HttpServletResponse response) throws IOException {
		// �������ڴ����¼��servlet
		
		// ����������е��ˣ��û��ɹ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='/Servlet_testDemo/NewFile.jsp'");
		response.getWriter().write("��½�ɹ���������3s����ת�����û����ת������<a href=''>link</a>");
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
