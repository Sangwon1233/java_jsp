package service;

import java.util.List;

import dao.MemberDao;
import vo.Member;

public class MemberServiceImpl implements MemberService{//인터페이스 구현부 implements 추가

	private MemberDao memberDao = MemberDao.getInstance();
	@Override
	public int register(Member member) {
		// TODO Auto-generated method stub
		return memberDao.insert(member);
	}

	@Override
	public Member findBy(String id) {
		// TODO Auto-generated method stub
		return memberDao.selectOne(id);
	}

	@Override
	public boolean login(String id, String pw) {
		Member m = findBy(id);
		return m != null && m.getPw().equals(pw);//로그인 성공
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Member member) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
