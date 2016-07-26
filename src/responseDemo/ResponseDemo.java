package responseDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ��¼��ʱ�����Ҫ�������ض��򣬲���ת������ַ���ᷢ���仯�����û��ܸ��ܵ�ҳ����ת

//����һ������²��������ض��򣬼��ط���������
//�����ض���
@WebServlet("/ResponseDemo")
public class ResponseDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setStatus(302);
		response.setHeader("location", "Servlet_testDemo/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 