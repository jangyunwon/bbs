package Study08_DB;
//DTO=VO=Bean : getter(),setter()
public class User {
	private String id;
	private String password;
	private String name;
	private int age;
	private String addr;
	private String email;
	
	public User(String id, String password, String name, int age, String addr, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
	String result = "아이디 : "+id+" , 비밀번호 : "+password+" ,이름 : "+name;
		return result;
	}
}
