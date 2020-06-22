package cn.gameboys.diy.ioc;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DiyHandlers extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserParserDefinitions2());
	}
}
	