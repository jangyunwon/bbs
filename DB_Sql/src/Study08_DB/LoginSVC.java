package Study08_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {
	Connection con=null;
	Statement stmt = null;
	//static 초기화 블럭 - 실행시 가장먼저 실행이 된다
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {}
			}
	public void connect() {
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!!!");
			
		}catch (SQLException e) {
				System.out.println("주소,id,pw가 다릅니다.");
			}

	}
public User login(String id,String password) {
	connect();
	User user = null;
	try {
	
		stmt = con.createStatement();
		String sql = "SELECT * FROM member1 WHERE id = '" + id + "' AND " +
				"password = '" + password + "'";
		ResultSet rs = stmt.executeQuery(sql);

		
		if(rs.next()) {
			id = rs.getString(1);
			password=rs.getString(2);
			String name=rs.getString(3);
			int age= rs.getInt(4);
			String addr=rs.getString(5);
			String email=rs.getString(6);

			user = new User(id, password, name, age, addr, email);
		}
	
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
    System.out.println("정상종료");
    try {
		con.close();
		stmt.close();
	} catch (SQLException e) {
		
	}
    finally {
    	try {
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	
		return user;
    }
}
}
