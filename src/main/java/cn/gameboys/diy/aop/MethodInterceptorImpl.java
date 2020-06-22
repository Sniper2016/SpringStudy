package cn.gameboys.diy.aop;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月22日 下午3:22:42
 */
public class MethodInterceptorImpl implements MethodInterceptor {
	private Map<Method, List<AbstractAdvisor>> advisorMap;

	public MethodInterceptorImpl(Map<Method, List<AbstractAdvisor>> advisorMap) {
		this.advisorMap = advisorMap;
	}

	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		List<AbstractAdvisor> advisorList = advisorMap.get(method);
		if (advisorList == null) {
			return methodProxy.invokeSuper(o, objects);
		} else {
			MethodInvocation methodInvocation = new MethodInvocation(o, method, objects, methodProxy, advisorList);
			return methodInvocation.proceed(methodInvocation);
		}
	}
}
