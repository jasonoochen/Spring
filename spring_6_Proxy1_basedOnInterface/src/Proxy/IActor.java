package Proxy;

/*
 * 模拟一个经纪公司
 */
public interface IActor {
	/*
	 * 基本的演出
	 */
	public void basicAct(float money);
	
	/*
	 * 危险的演出
	 */
	public void dangerousAct(float money);
}
