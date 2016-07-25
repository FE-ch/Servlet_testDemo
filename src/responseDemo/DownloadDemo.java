package responseDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 下载图片
@WebServlet("/DownloadDemo")
public class DownloadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = this.getServletContext().getRealPath("/Download/大爷.png");
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		
		//如果是中文名字图片，需要经过url编码
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(path);
			int len = 0;
			byte[] buffer = new byte[1024];
			out = response.getOutputStream();
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
