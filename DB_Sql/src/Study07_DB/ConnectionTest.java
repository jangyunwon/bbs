package Study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	Connection con=null;
	Statement stmt = null;
	//static 초기화 블럭 - 실행시 가장먼저 실행이 된다
	static {try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		
	}
		
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
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}

}
