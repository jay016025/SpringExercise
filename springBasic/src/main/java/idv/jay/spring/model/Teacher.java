package idv.jay.spring.model;

import java.util.List;
import java.util.Map;

public class Teacher {
	
	private Integer id;
	private String tname;
	private List<String> cls;
	private List<Student> students;
	private Map<String, String> bossMap;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public List<String> getCls() {
		return cls;
	}

	public void setCls(List<String> cls) {
		this.cls = cls;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Map<String, String> getBossMap() {
		return bossMap;
	}

	public void setBossMap(Map<String, String> bossMap) {
		this.bossMap = bossMap;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tname=" + tname + ", cls=" + cls + ", students=" + students + ", bossMap="
				+ bossMap + "]";
	}
	
}
