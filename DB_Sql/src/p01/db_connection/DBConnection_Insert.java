package p01.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
//executeQuery(String sql): select문 사용시
//executeUpdate(String sql): insert, delete, update사용시
public class DBConnection_Insert {
	public static void main(String[] args) {
//		delete goodsinfo where code='10005';
		Connection conn = null;
		Statement stmt = null;
        try {
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = conn.createStatement();
			
			String query = "insert into goodsinfo values('10001','LCD TV',135000,'삼성')";
			int count= stmt.executeUpdate(query);
			if(count>0) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("데이터가 저장되지 않았습니다.");
			}
		
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("정상종료");
        try {
			conn.close();
		} catch (SQLException e) {
			
		}
	}
	}


