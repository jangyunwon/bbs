package mms.member.dao;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.vo.Member;
//오라클에서 dao로 가져오고 service로 보낸다 (같은 모델)
public class MemberDAO {
	Connection con;
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(Member newMember) {
		
		
	String sql = "insert~~"











		
		
	}
	
	public ArrayList<Member> selectMemberList() {








		
		
	}
	
	public Member selectOldMember(String name) {













		
	
	}
	
	public int updateMember(Member updateMember) {








		
		
	}
	
	public int deleteMember(String name) {








		
		


}
