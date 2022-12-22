package dao;

import dto.MemberDTO;

public class MariaDAO implements DAO_INF {

	@Override
	public void insert(MemberDTO m) {
		System.out.println("마리아디비저장");
		
	}

}
