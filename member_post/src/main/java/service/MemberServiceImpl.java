package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.MemberDao;
import mapper.MemberMapper;
import mapper.PostMapper;
import utills.MybatisInit;
import vo.Member;

public class MemberServiceImpl implements MemberService{//인터페이스 구현부 implements 추가

	@Override
	public int register(Member member) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			MemberMapper mapper=session.getMapper(MemberMapper.class);
					return mapper.insert(member);
	
		}
	}
	@Override
	public Member findBy(String id) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession()){
			MemberMapper mapper=session.getMapper(MemberMapper.class);
					return mapper.selectOne(id);
	
		}
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
