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
 * @author 先生
 *	@category request 的常用方法
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
		
//		最常用的获取方式
//		获取请求数据时，一定要先检查再使用
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
		// 某个name有多个value
		String[] values = request.getParameterValues("username");
		for (int i = 0; values != null && i < values.length ;i++) {
			System.out.println(values[i]);
		}
		
		System.out.println("----------4---------");
		// 客户端提交数据给服务器，通常会封装到对象里
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 实验没有成功
		System.out.println(user);
		
		System.out.println("----------5---------");
		// 通常文件上传通过这种方式获取
		InputStream in = request.getInputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while((len = in.read(buffer)) > 0) {
			System.out.println(new String(buffer, 0, len));
		}
	}

	// 常用request方法
	private void test(HttpServletRequest request) {
		// 在做论坛的时候，可以用URI来截取用户请求，管理用户权限
		// 统计页面访问次数，URI++
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		
//		http://localhost:8080/Servlet_testDemo/RequestDemo1?name=aaa
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());
		
		// 需要在DNS上注册才能生效
		System.out.println(request.getRemoteHost());
		
		System.out.println(request.getRemotePort());
		
		// GET
		System.out.println(request.getMethod());
		System.out.println(request.getHeader("User-Agent"));
	}

	// 获取所有request头信息
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
