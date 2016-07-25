package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// �����ȡ��Դ���ļ�����servlet����ôֻ��ͨ��--��װ����--ȥ��
// �׶ˣ��ļ�����̫��

public class UserDao {

	
	private static Properties dbConfig = new Properties();
	static {
		// �����ʱ�޸��˷������µ���Դ�ļ���ˢ��ҳ�����ݲ�����䣬��Ϊ��ֻװ��һ��
		/*try {
			InputStream in = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
			dbConfig.load(in);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}*/
		
		// Ϊ�˵õ����µ����ݣ�ֻ�ܲ��ô�ͳ��ʽ������
		// ���Ǳ�����ͨ����װ�����ķ�ʽ�õ��ļ���λ�ã�Ȼ��ͨ����ͳ��ʽ��ȡ��Դ�ļ����ݣ�updated��
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
