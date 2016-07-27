package request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.User;

/**
 * @author ����
 *	@category request �ĳ��÷���
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test2(request);
	}

	
	// 
	private void test2(HttpServletRequest request) throws IOException {
		
		System.out.println("----------1---------");
		
//		��õĻ�ȡ��ʽ
//		��ȡ��������ʱ��һ��Ҫ�ȼ����ʹ��
		String value = request.getParameter("username"); 
		if (value != null && value.trim() != null) {
			System.out.println(value);
		} else {
			System.out.println("Please input a valid name!");
		}
		
		System.out.println("----------2---------");
		
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String paraValue = request.getParameter(name);
			System.out.println(name + " : " + paraValue);
		}
		
		System.out.println("----------3---------");
		// ĳ��name�ж��value
		String[] values = request.getParameterValues("username");
		for (int i = 0; values != null && i < values.length ;i++) {
			System.out.println(values[i]);
		}
		
		System.out.println("----------4---------");
		// �ͻ����ύ���ݸ���������ͨ�����װ��������
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// ʵ��û�гɹ�
		System.out.println(user);
		
		System.out.println("----------5---------");
		// ͨ���ļ��ϴ�ͨ�����ַ�ʽ��ȡ
		InputStream in = request.getInputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
	}

	// ����request����
	private void test(HttpServletRequest request) {
		// ������̳��ʱ�򣬿�����URI����ȡ�û����󣬹����û�Ȩ��
		// ͳ��ҳ����ʴ�����URI++
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		
//		http://localhost:8080/Servlet_testDemo/RequestDemo1?name=aaa
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());
		
		// ��Ҫ��DNS��ע�������Ч
		System.out.println(request.getRemoteHost());
		
		System.out.println(request.getRemotePort());
		
		// GET
		System.out.println(request.getMethod());
		System.out.println(request.getHeader("User-Agent"));
	}

	// ��ȡ����requestͷ��Ϣ
	private void test1(HttpServletRequest request) {
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + " : " + value);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
