package idv.jay.lifeCycle;

/**
 * spring bean 的生命週期
 * @author 凱傑
 *
 */
public class LifeCycle {
	
	private final String INSTENCE_MSG = "1.createBean";
	private final String DI_MSG = "2.beanInjection";
	private final String INIT_MSG = "3.beanInit";
	private final String USE_MSG = "4.useBean";
	private final String DESTROY_MSG = "5.destroyBean";
	
	private String di;
	
	/**
	 * 生命週期1 : 創建實體
	 */
	public LifeCycle() {
		super();
		System.out.println(this.INSTENCE_MSG);
	}

	public String getDi() {
		return di;
	}
	
	/**
	 * 生命週期2: 依賴注入
	 * @param di
	 */
	public void setDi(String di) {
		this.di = di;
		System.out.println(this.DI_MSG);
	}
	
	/**
	 * 生命週期3: bean初始化
	 */
	public void init() {
		System.out.println(this.INIT_MSG);
	}
	
	/**
	 * 生命週期4: 使用bean
	 */
	@Override
	public String toString() {
		return this.USE_MSG;
	}
	
	/**
	 * 生慶周期5: 銷毀bean
	 */
	public void destroy() {
		System.out.println(this.DESTROY_MSG);
	}
	
	
}
