package idv.jay.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {
	
	/**
	 * 	代理的目標物件，一般型別為Object
	 */
	private MathImpl math;
	
	public ProxyUtil(MathImpl math) {
		this.math = math;
	}
	
	/**
	 * 	取得代理物件方法
	 * @return
	 */
	public Object getProxy() {
		/*
		 * 	第一個參數 : class loader，每個class都需要，
		 * 		因此共用同一個loader(一個class loader可以作用許多的class)
		 * 
		 * 	第二個參數 : interfaces，需知道目標物件所有的方法，
		 * 		因此需得到目標物件所繼承的介面
		 * 
		 * 	第三個參數 : InvocationHandler，為一個介面，只有一個抽象方法，
		 * 		定義代理物件怎麼執行目標物件的方法，但要保證結果的一致性。
		 * 
		 * 	**透過Proxy.newProxyInstance創建出來的代理物件都會繼承Proxy，
		 * 		並且實現目標物件的所有介面，這樣使代理物件知道他要實現哪些功能。
		 * 
		 * 	**實現功能透過InvocationHandler來實現。
		 * 
		 */
		
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), 
				math.getClass().getInterfaces(), new InvocationHandler() {
					//內部class
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						MyLogger.before(method.getName(), Arrays.toString(args));
						Object result = method.invoke(math, args);
						MyLogger.after(method.getName(), result);
						return result;
					}
				});
	}
}
