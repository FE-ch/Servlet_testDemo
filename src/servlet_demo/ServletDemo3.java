package servlet_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDemo3")
public class ServletDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		test1();
		test2();
//		test3();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	��ȡ��Դ�ļ�
	private void test1() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties props = new Properties();		// ����Ϊmap ��ʽ
		props.load(in);
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
	}
	
	// ͨ��getRealPath�����ȵõ���Դ���ƣ��ֵõ���Դ����
	private void test2() throws IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		String filename = path.substring(path.lastIndexOf("\\"));

		System.out.println("��ǰ��ȡ������Դ�����ǣ�" + filename);
		FileInputStream in = new FileInputStream(path);
		Properties props = new Properties();		// ����Ϊmap ��ʽ
		props.load(in);
		
		System.out.println("��ǰ��ȡ������Դ�����ǣ�");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
	}
	
	private void test3() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		Properties props = new Properties();		// ����Ϊmap ��ʽ
		props.load(in);
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
	}

}
