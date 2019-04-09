package Proxy;


/*
 * 一个演员
 */
public class Actor implements IActor {
	
	/*
	 * 基本的演出
	 */
	public void basicAct(float money) {
		System.out.println("开始基本表演：" + money);
	}
	
	/*
	 * 危险的演出
	 */
	public void dangerousAct(float money) {
		System.out.println("开始危险表演：" + money);
	}
}
