package cn.gameboys.diy.ioc;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class UserParserDefinitions2 implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String id = element.getAttribute("id");
		String name = element.getAttribute("name");
		String password = element.getAttribute("password");
		String phone = element.getAttribute("phone");
		RootBeanDefinition nodeWrapDefinition = new RootBeanDefinition();
		//该BeanDefinition对应的是什么类
		nodeWrapDefinition.setBeanClass( UserConfig.class);
		//name是解析标签后获得的值
		nodeWrapDefinition.getPropertyValues().addPropertyValue("id", id);
		nodeWrapDefinition.getPropertyValues().addPropertyValue("name", name);
		nodeWrapDefinition.getPropertyValues().addPropertyValue("password", password);
		nodeWrapDefinition.getPropertyValues().addPropertyValue("phone", phone);
		

		
/*		RuntimeBeanReference refBean = new RuntimeBeanReference(ref);
        nodeWrapDefinition.getPropertyValues().addPropertyValue("station", refBean);
		*/
		
		
        parserContext.getRegistry().registerBeanDefinition(id,nodeWrapDefinition);
        
        
		return nodeWrapDefinition;
	}

}
