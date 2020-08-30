package idv.jay.proxy;

/**
 * 	自訂義log (練習aop用)
 * @author User
 *
 */
public class MyLogger {
	
	/**
	 * 	log紀錄(前)
	 * @param methodName
	 * @param args
	 */
	public static void before(String methodName, String args) {
		System.out.println("method: " + methodName + ", " + "arguments: " + args);
	}
	
	/**
	 * 	log紀錄(後)
	 * @param methodName
	 * @param result
	 */
	public static void after(String methodName, Object result) {
		System.out.println("method: " + methodName + ", " + "result: " + result);
	}
}
