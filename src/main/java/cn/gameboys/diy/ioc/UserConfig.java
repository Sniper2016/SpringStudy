package cn.gameboys.diy.ioc;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class UserConfig implements Serializable, BeanFactoryAware {
	private static final long serialVersionUID = -5680714598279222721L;

	private String id;

	private String name;

	private String password;

	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("name=" + name).append(" password=" + password).append(" phone=" + phone).append(" id").append(id);
		return sb.toString();
	}

	BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("setBeanFactory");
	}
}
