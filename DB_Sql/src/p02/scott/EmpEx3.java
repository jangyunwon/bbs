package p02.scott;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//조건 - 스캐너 입력을 받아서 empno=7902에 해당 레코드(tuple) 출력하기
public class EmpEx3 {

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
		   Scanner sc = new Scanner(System.in);
		   System.out.println("[EMPNO 입력: ]");
		   int no = sc.nextInt();//7902
		   String query="select* from emp where empno= "+ no;
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
		sc.close();
		rs.close();
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
