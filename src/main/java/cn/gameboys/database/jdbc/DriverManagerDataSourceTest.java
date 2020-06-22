package cn.gameboys.database.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.gameboys.database.dao.HelloDAO;

/**
 * 测试DriverManagerDataSource数据源
 */
public class DriverManagerDataSourceTest {

	@Test
	public void testHello() {
		// 根据spring配置文件创建应用上下文
		ApplicationContext context = new ClassPathXmlApplicationContext("database-DriverManagerDataSource.xml");
		// 从容器中获取bean
		HelloDAO helloDAO = (HelloDAO) context.getBean("helloDAO");
		// 调用插入方法
		helloDAO.insertTest();
	}

}
