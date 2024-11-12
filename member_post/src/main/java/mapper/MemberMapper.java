package mapper;

import vo.Member;

public interface MemberMapper {

	int insert(Member member);
	Member selectOne(String id);
}
