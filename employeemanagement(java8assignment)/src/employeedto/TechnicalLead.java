package employeedto;

import java.time.LocalDateTime;

public class TechnicalLead {

	int id;
	String name;
	int age;
	LocalDateTime joinDate;
	boolean isManager;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "TechnicalLead [id=" + id + ", name=" + name + ", age=" + age + ", joinDate=" + joinDate + ", isManager="
				+ isManager + "]";
	}

	public TechnicalLead(int id, String name, int age, LocalDateTime joinDate, boolean isManager) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.joinDate = joinDate;
		this.isManager = isManager;
	}

}
