package cn.gameboys.diy.aop;
/**
 * 
* @Description: 
* @author: www.gameboys.cn
* @date:2020年6月22日 下午3:22:42
 */
public interface Proceed {
	Object proceed(MethodInvocation methodInvocation) throws Throwable;
}
