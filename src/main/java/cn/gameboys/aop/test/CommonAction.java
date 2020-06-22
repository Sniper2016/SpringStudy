package cn.gameboys.aop.test;

public abstract class CommonAction implements Runnable {
	// 参数
	protected Object[] params;

	public CommonAction() {

	}

	public CommonAction(Object... params) {
		this.params = params;
	}

	@Override
	public abstract void run();

	public Object[] getParams() {
		return params;
	}

	public void addParams(Object... param) {
		this.params = param;
	}

}
