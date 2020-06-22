package cn.gameboys.aware;

import org.springframework.beans.factory.BeanNameAware;

public class User implements BeanNameAware {
	private String id;

	private String name;
	
	private String beanName;
	

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", beanName=" + beanName + "]";
	}
	
	
	
	

}
