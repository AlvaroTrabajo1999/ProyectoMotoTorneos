package modelo.dao;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * Clase de utilidad para obtener una configuraciónn de MyBatis
 * @author daw
 */
public class MyBatisUtil {
	private static SqlSessionFactory factory;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(MyBatisUtil.class);
	
	private MyBatisUtil() {
	}

	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}










