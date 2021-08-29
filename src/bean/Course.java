package bean;

public class Course {
	private String Code;
	private String Name;
	private int Credit;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCredit() {
		return Credit;
	}

	public void setCredit(int credit) {
		Credit = credit;
	}

	public Course(String code, String name, int credit) {
		super();
		Code = code;
		Name = name;
		Credit = credit;
	}

	@Override
	public String toString() {
		return  Code + " | " + Name + " | " + Credit + "";
	}
	
}
