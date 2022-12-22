package dao;

import dto.MemberDTO;

public class MongoDB implements DAO_INF {

	@Override
	public void insert(MemberDTO m) {
		System.out.println("몽고디비저장완료");
		
	}

}
