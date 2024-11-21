package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dao.ReplyCri;
import vo.Reply;

public interface ReplyMapper {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(Long rno);
	int deleteAll(Long pno);
	
	Reply selectOne(Long rno);
	List<Reply> selectList(@Param("pno") Long pno,@Param("cri") ReplyCri cri);//파라미터가 2개 이상일땐 어노테이션 파람을 써서 사용
	List<Reply> selectListByMe(Reply reply);
}
