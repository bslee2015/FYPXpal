
package entity;

public class Student {
	private String id;
	private String username;
	private String password;
	private String name;
	private String classOfStudent;
	private String email;
	private String enrollmentyear;
	private String accountCreationDateTime;
	
	public Student(String id, String username, String password, String name, String classOfStudent, String email,
			String enrollmentyear, String accountCreationDateTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.classOfStudent = classOfStudent;
		this.email = email;
		this.enrollmentyear = enrollmentyear;
		this.accountCreationDateTime = accountCreationDateTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassOfStudent() {
		return classOfStudent;
	}
	public void setClassOfStudent(String classOfStudent) {
		this.classOfStudent = classOfStudent;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnrollmentyear() {
		return enrollmentyear;
	}
	public void setEnrollmentyear(String enrollmentyear) {
		this.enrollmentyear = enrollmentyear;
	}
	public String getAccountCreationDateTime() {
		return accountCreationDateTime;
	}
	public void setAccountCreationDateTime(String accountCreationDateTime) {
		this.accountCreationDateTime = accountCreationDateTime;
	}
	
	
	
}