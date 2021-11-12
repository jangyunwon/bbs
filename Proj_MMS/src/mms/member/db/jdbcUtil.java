package mms.member.db;
//package mms.member.db; 
//데이터 베이스 관련 처리에 필요한 공통적인 기능의 클래스가 정의되는 패키지
import java.sql.Connection;
import java.sql.SQLException;


public class jdbcUtil {
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
	}

	
	//transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit();//insert,update,delete
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
	}
	public static void rollback (Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {

		}
	}

	
	
	
}
