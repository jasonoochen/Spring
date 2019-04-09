package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 模拟一个剧组
 */
public class Client {

	public static void main(String[] args) {
		final Actor actor = new Actor();
//		actor.basicAct(100f);
		/*
		 * 动态代理
		 * 	作用：在不改变源码的基础上，对已有方法增强。（它是AOP思想的实现技术）
		 * 分类：
		 * 		基于接口的动态代理：
		 * 			要求：被代理类至少实现一个接口
		 * 			提供者：JDK官方
		 * 			创建动态代理的方法： newProxyInstance(ClassLoader, Class[], InvocationHandler)
		 * 				参数的含义：
		 * 					ClassLoader: 类加载器。和被代理对象使用相同的类加载器。一般都是固定写法
		 * 								（example: actor.getClass().getClassLoader()）
		 * 					Class[]: 字节码数组。被代理对象实现的接口。（要求代理对象和被代理对象具有相同的行为）。一般写法固定
		 * 								（example: actor.getClass().getInterface()）
		 * 					InvocationHandler: 它是一个接口，用于提供增强代码。一般写一个该接口的实现类。实现类可以是匿名内部类。
		 * 										它的含义是指定如何代理。此处代码具有专一性。
		 * 								策略模式：
		 * 									使用要求：数据已经存在，有固定的目标，达成目标的过程就是策略。
		 * 		基于子类的动态代理：						
		 */
		IActor proxyActor = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), 
				new InvocationHandler() {
			/*
			 * 执行该被代理对象的任何方法都会经过该方法，该方法有拦截的功能
			 * 方法的参数
			 * 		Object proxy:代理对象的引用，不一定会用
			 * 		Method method: 当前执行的方法
			 * 		Object[] args: 当前执行方法所需的参数
			 * 返回值：
			 * 		当前执行方法的返回值
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Object rtValue = null;
				//1.取出执行方法中的参数：演出费用
				Float money = (Float)args[0];
				//2.判断当前执行的方法
				if("basicAct".equals(method.getName())) {
					//基本演出
					if(money > 10000) {
						//执行方法，开始演出
						rtValue = method.invoke(actor, money/2);
					}
				}
				if("dangerAct".equals(method.getName())) {
					//危险演出
					if(money > 50000) {
						//执行方法
						rtValue = method.invoke(actor, money/2);
					}
				}
				return rtValue;
			}
		});
		proxyActor.basicAct(20000);
	}

}
