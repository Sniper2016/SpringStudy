package cn.gameboys.scope;


public class User {
	private String id;

	private String name;

	private String beanName;

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
