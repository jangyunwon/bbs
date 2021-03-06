package Stored_Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest {
	Connection conn=null;
	
	
	//static 초기화 블럭 - 실행시 가장먼저 실행이 된다
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		
	}
		
	}
	public void connect() {
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("Connection Success!!!");
			
		}catch (SQLException e) {
				System.out.println("주소,id,pw가 다릅니다.");
			}

	}
	
	
	//저장프로시저 호출전 데이터 입력
		public void insert(){	
			PreparedStatement pstmt = null;
			connect();
			String sql = "insert into member3 values(?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "Alpha");
				pstmt.setString(2, "1234");
				pstmt.setString(3, "AI");
				pstmt.setInt(4, 20);
				pstmt.setString(5, "LA");
				pstmt.setString(6, "Alpha@aa.com");
				int count = pstmt.executeUpdate();
				if(count>0) 
					System.out.println("insert success!!!");
				 else
					System.out.println("insert fail!!!");

			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}






			
		}
		
		
		public void select(){
			PreparedStatement pstmt =null; //밖에서 받아야 하기 때문에?
			ResultSet  rs=null;// 메소드안에서 선언된 변수는 반드시 초기화해야하기때문에
			connect();
			String sql = "select *from member3";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("아이디: "+rs.getString(1)+
							", 비밀번호: "+rs.getString(2)+
							", 이름: "+rs.getString(3)+
							", 나이: "+rs.getString(4)+
							", 주소: "+rs.getString(5)+
							", 이메일: "+rs.getString(6)
							);
					
				}
			} catch (SQLException e) {
				
			} finally {
			
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}











			
		}
		
	//저장프로시저 호출 후 데이터 입력
		public void insertMember(){
			
			CallableStatement cs  = null;
			connect();
			
			try {
				String sql = "{call user_insert(?,?,?,?,?,?)}";
				cs = conn.prepareCall(sql);
				
				cs.setString(1, "Procedure");
				cs.setString(2, "1234");
				cs.setString(3, "홍길동");
				cs.setInt(4, 19);
				cs.setString(5, "강원도");
				cs.setString(6, "hong@aa.com");
				int count = cs.executeUpdate();
				if(count>0) 
					System.out.println("insert success!!!");
				 else
					System.out.println("insert fail!!!");

			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {
					cs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

















			
		}
		public static void main(String[] args) {
			ProcedureTest pt = new ProcedureTest();
			
			System.out.println("*** 저장 프로시저 호출 후 데이터 ***");
			pt.insert();
			pt.select();

			System.out.println("*** 저장 프로시저 호출 후 데이터 ***");
			pt.insertMember();
			pt.select();



		
		}	
	}


