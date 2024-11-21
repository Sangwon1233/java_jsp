package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dao.ReplyCri;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mapper.ReplyMapper;
import utills.MybatisInit;
import vo.Member;
import vo.Reply;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReplyServiceImpl implements ReplyService  {
	@Getter
	private static ReplyService instance = new ReplyServiceImpl();
	
	public int write(Reply reply) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
					return mapper.insert(reply);
		}
	}

	@Override
	public int modify(Reply reply) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
					return mapper.update(reply);
		}
	}

	@Override
	public int remove(Long rno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
					return mapper.delete(rno);
		}
	}

	@Override
	public int removeAll(Long pno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
					return mapper.deleteAll(pno);
		}
	}

	@Override
	public Reply findBy(Long rno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
					return mapper.selectOne(rno);
		}
	}


	@Override
	public Map<String, List<Reply>> list(Long pno, ReplyCri cri , Object writer) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			ReplyMapper mapper=session.getMapper(ReplyMapper.class);
			Map<String, List<Reply>> map= new HashMap<>();
			map.put("list", mapper.selectList(pno, cri));
			
			if(writer !=null) {	
				Reply reply = new Reply();
				reply.setWriter(((Member)writer).getId());
				reply.setPno(pno);
//				map.put("list",mapper.selectList(pno, cri));
				map.put("myList",mapper.selectListByMe(reply));
			}
			return map;
		}

	}

}
