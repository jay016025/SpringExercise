package idv.jay.spring.model;

public class Person {
	
	/**
	 * 不用基本型別而用包裝型別
	 * 1.資料庫查詢資料沒資料賦值為null
	 * 2.int 預設值為0，風裝型別預設為null，意義不同
	 */
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "person [id=" + id + ", name=" + name + "]";
	}
	
}
