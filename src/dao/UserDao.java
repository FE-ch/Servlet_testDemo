package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 如果读取资源的文件不是servlet，那么只能通过--类装载器--去读
// 弊端：文件不能太大

public class UserDao {

	
	private static Properties dbConfig = new Properties();
	static {
		// 如果此时修改了服务器下的资源文件，刷新页面数据并不会变，因为类只装载一次
		/*try {
			InputStream in = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
			dbConfig.load(in);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}*/
		
		// 为了得到更新的数据，只能采用传统方式来读。
		// 但是必须先通过类装载器的方式得到文件的位置，然后通过传统方式读取资源文件数据（updated）
		try {
			String path = UserDao.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream in = new FileInputStream(path);
			dbConfig.load(in);
			System.out.println(dbConfig.getProperty("url"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public void update() throws IOException {
		
		String url = dbConfig.getProperty("url");
		
	}
	
	public void find() {
		
	}
	
	public void delete() {
		
	}

}
