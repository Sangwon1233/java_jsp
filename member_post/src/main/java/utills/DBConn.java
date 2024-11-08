package utills;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {
	public static Connection getConnection() throws ClassNotFoundException,SQLException{
//		Class.forName("org.mariadb.jdbc.Driver");
//		return DriverManager.getConnection("jdbc:mariadb://3.34.47.178:3306/post", "sample","1234");
//		
	
			Properties props= new Properties();
			
			InputStream  is = DBConn.class.getClassLoader().getResourceAsStream("db.properties");
			try {
				props.load(is);
			}
			catch (IOException e) {
				e.printStackTrace();// TODO: handle exception
			}
			String driver=props.getProperty("driver");
			String host=props.getProperty("host");
			String username=props.getProperty("username");
			String password=props.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(host,username,password);
			
	//		FileReader fileReader = new FileReader("src");//
			
	//		System.out.println(fileReader);
	//		System.out.println(ps.getProperty("java.class.path"));
	//		ps.keySet().forEach(System.out::println);
			
	
	}	
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
		

}
