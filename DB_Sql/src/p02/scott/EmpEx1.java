package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpEx1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
        try {
        	//1.driver 연결
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			//2.계정 연결
			conn = DriverManager.getConnection(url, "scott", "scott");//주소,DB:ID,암호
		   stmt = conn.createStatement();
		   //3.query
		   String query="select* from emp";
		   //4.실행과 리턴
		   ResultSet rs = stmt.executeQuery(query);
		   while(rs.next()) {
			   int empno = rs.getInt("empno");
			   String ename = rs.getString("ename");
			   String job = rs.getString("job");
			   int mgr = rs.getInt("mgr");
			   Date hiredate = rs.getDate("hiredate");
			   int sal = rs.getInt("sal");
			   int comm = rs.getInt("comm");
			   int deptno = rs.getInt("deptno");
			   System.out.println(empno+" : "+ename+" : "+ job+" : "+mgr+" : "+
					   			  hiredate+" : "+sal+" : "+comm+" : "+deptno);
		   }
			
		conn.close();
		stmt.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("정상종료");
	}

}
