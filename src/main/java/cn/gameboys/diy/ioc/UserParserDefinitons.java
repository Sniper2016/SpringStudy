package cn.gameboys.diy.ioc;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author Sniper
 * @date 2018年10月10日
 */
public class UserParserDefinitons extends AbstractSingleBeanDefinitionParser{

	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserConfig.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		String password = element.getAttribute("password");
		String phone = element.getAttribute("phone");
		builder.addPropertyValue("name", name);
		builder.addPropertyValue("password", password);
		builder.addPropertyValue("phone", phone);
	}


}
