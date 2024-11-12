package utills;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisInit {
	private static MybatisInit init = new MybatisInit();
	public static MybatisInit getInstance() {
		return init;
	}

	public SqlSessionFactory sqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
	}

	public static void main(String[] args) {
		System.out.println(new MybatisInit().sqlSessionFactory());
	}
}
