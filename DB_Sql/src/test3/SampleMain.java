package test3;

import java.util.ArrayList;

public class SampleMain {
	public static void main(String[] args) {
		SampleDAO dao = new SampleDAO();
		
		ArrayList<SampleDTO> books = dao.findAll();
			// DTO를 저장하는 리스트
			


		//for 출력
		for(SampleDTO s : books) {
			System.out.println("id: "+s.getId());
			System.out.println("name: "+s.getName());
			System.out.println("price: "+s.getPrice());
			System.out.println();
		}


		
	
	}
	

}
