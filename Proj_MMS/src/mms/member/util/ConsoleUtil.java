package mms.member.util;
//콘솔로부터 사용자가 입력한 정보를 읽어 들이거나 콘솔로 필요한
//메세지를 출력하는 역할을 하는 클래스가 정의되는 패키지

import java.util.Scanner;

import mms.member.vo.Member;

//키보드 입력
public class ConsoleUtil {
	
	public Member getMember (Scanner sc) {
		
		return new Member();
	}
}
