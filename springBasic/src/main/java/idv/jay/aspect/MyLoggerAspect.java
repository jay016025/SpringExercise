package idv.jay.aspect;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//標註目前class為一個切面
@Aspect
@Component
@Order(1)//定義切面的優先權，數字越小優先權越高，default: int的最大值
public class MyLoggerAspect {
	
	/**
	 * 	定義一個公共切入點，其他的通知可直接引用
	 */
	@Pointcut(value = "execution(public int idv.jay.proxy.*.*(..))")
	public void pointcut() {}
	
	/**
	 * @Before:將方法指定為前置通知
	 * 	必須配置value，其值為切入點表達式
	 * 	前置通知:作用於方法執行前
	 * 	@Before(value = "execution(* idv.jay.proxy.*.*(..))")
	 * 	第一個* : 代表任意存取修飾子和回傳值
	 * 	第二個* : 代表任意class
	 * 	第三個* : 代表任意方法
	 * 	..代表任意參數
	 * @param point
	 */
//	@Before(value = "execution(public int idv.jay.proxy.MathImpl.add(int, int))")
	@Before(value = "pointcut()")
	public void before(JoinPoint point) {
		//取得方法參數
		Object[] args = point.getArgs();
		//取得方法名稱
		String methodName = point.getSignature().getName();
		
		System.out.println("前置通知; MethodName: " + methodName + ", arguments: " + Arrays.toString(args));
	}
	
	/**
	 * @After:將方法標示為後置通知
	 * 	後置通知: 作用於方法的finally區塊中,不管有無例外接執行
	 */
	@After(value = "pointcut()")
	public void after() {
		System.out.println("後置通知");
	}
	
	/**
	 * @AfterReturning:將方法標示為回傳通知
	 * 	回傳通知: 作用於方法執行後
	 * 	可透過returning屬性設置回傳值的參數名
	 * 	方法中代表回傳的參數名稱必須和設置的一致
	 * @param point
	 * @param result
	 */
	@AfterReturning(value = "pointcut()", returning = "result")
	public void afterReturning(JoinPoint point, Object result) {
		String methodName = point.getSignature().getName();
		System.out.println("回傳通知; MethodName: " + methodName + ", result: " + result);
		
	}
	
	/**
	 * @AfterThrowing:將方法標示為例外通知
	 * 	例外通知: 作用於方法拋出例外時
	 * 	可通過throwing設置，接收方法拋出的例外訊息
	 * 	可在參數設置指定的例外型別，對指定的例外進行處理
	 * @param ex
	 */
	@AfterThrowing(value = "pointcut()", throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("throws exception!! " + ex);
	}
	
//	@Around(value = "pointcut()")
//	public Object around(ProceedingJoinPoint point) {
//		
//		Object result = null;
//		
//		try {
//			System.out.println("around: 前置");
//			result = point.proceed();//相當於方法執行
//			System.out.println("around: 回傳");
//			return result;
//		} catch (Throwable e) {
//			
//			e.printStackTrace();
//			System.out.println("around: 例外");
//		} finally {
//			System.out.println("around: 後置");
//		}
//		return 0;
//	}
}
