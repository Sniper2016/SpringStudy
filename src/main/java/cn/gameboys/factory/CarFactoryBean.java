package cn.gameboys.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CarFactoryBean implements FactoryBean<CarBean> {

	@Override
	public CarBean getObject() throws Exception {

		return new CarBean();
	}

	@Override
	public Class<?> getObjectType() {
		return CarBean.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
