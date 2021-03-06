package Study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest {
	Connection con=null;
	Statement stmt = null;
	int count;
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
	public void insert(){
	
	// 'aaa','1111','홍길동','22','서울시','a@a.com'"
		try {
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();
			
			String query = "insert into member1 values( 'aaaa','11111','홍길동1','22','서울시','a@a.com')";
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
			con.close();
		} catch (SQLException e) {
			
		}}
	public void select(){
		 try {
				//Class.forName("java.lang.String");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				
				con = DriverManager.getConnection(url, "javalink", "javalink");
				stmt = con.createStatement();
				String query = "select * from member1";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					String id = rs.getString("id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String age = rs.getString("age");
					String email = rs.getString("email");
					String addr = rs.getString("addr");
					System.out.println(id+" : "+password+" : "+name+" : "+age+" : "+addr+" : "+email);
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	        System.out.println("정상종료");
	        try {
				con.close();
			} catch (SQLException e) {
				
			}
	}
	
	public void update(){
 //id=aaa 를 찾아서 addr=부산시
		try {
			//Class.forName("java.lang.String");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();
			
			String query = "update member1 set name='aaa' where addr='부산시'";
			int count= stmt.executeUpdate(query);
			
			if(count>0)
				System.out.println("데이터가 업데이트 되었습니다.");
			else
				System.out.println("데이터가 업데이트되지 않았습니다.");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없음:: 해당 클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        System.out.println("정상종료");
        try {
			con.close();
		} catch (SQLException e) {
			
		}
		
	}
	public void delete(){
//id=aaa 삭제
		String query = "delete member1 where id='aaa'";
		try {
			count= stmt.executeUpdate(query);
			if(count>0) {
				System.out.println("delete success!");
			} else {
				System.out.println("delete fail!");
			}
		} catch (SQLException e) {
			
		}
		
	}


	public static void main(String[] args) {
		CRUDTest st = new CRUDTest();
		st.connect();
		st.insert();
		System.out.println("insert 수행 후");
		st.connect();
	    st.select();
		
		st.connect();
		st.update();
		
		System.out.println("update 수행 후");
		st.connect();
	    st.select();
		
		
	    st.connect();
	    st.delete();
		System.out.println("delete 수행 후");
		 st.delete();
		st.connect();
		st.select();				
	}
	}


