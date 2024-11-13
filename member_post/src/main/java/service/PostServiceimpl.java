package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.PostDao;
import dto.Criteria;
import mapper.AttachMapper;
import mapper.PostMapper;
import utills.MybatisInit;
import vo.Attach;
import vo.Post;

public class PostServiceimpl implements PostService  {
	private PostDao dao = new PostDao();
	public static void main(String[] args) {
		new PostServiceimpl().write(Post.builder().title("제목").content("abcd").writer("aa").cno(2).build());
	}
	
	
	public int write(Post post) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
			AttachMapper attachMapper=session.getMapper(AttachMapper.class);
			System.out.println(post);// post.getPno()의 값은 null이다
			mapper.insert(post);
			System.out.println(post);// post.getPno() 의 값이 not null이다
			post.getAttachs().forEach(a -> {
				a.setPno(post.getPno());
				attachMapper.insert(a);
			});
			
			
			return 0;
		}
	}
	
	public int modify(Post post) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
					return mapper.update(post);
		}
	}
	
	public int remove(Long pno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
			AttachMapper attachMapper=session.getMapper(AttachMapper.class);
			attachMapper.delete(pno);
					return mapper.delete(pno);
		}
	}
	
	public Post findBy(Long pno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
			AttachMapper attachMapper=session.getMapper(AttachMapper.class);
			Post post = mapper.selectOne(pno);
			
			return post;
		}
	}
	
	public List<Post> list(Criteria cri){
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
					return mapper.selectList(cri);
		}
	}
	

	@Override
	public int count(Criteria cri) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
					return mapper.getCount(cri);
		}
	}

	@Override
	public Post view(Long pno) {
		try(SqlSession session =  MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper=session.getMapper(PostMapper.class);
			AttachMapper attachMapper=session.getMapper(AttachMapper.class);
			mapper.increaseViewCount(pno);
			Post post = mapper.selectOne(pno);
			post.setAttachs(attachMapper.selectList(pno));
			return mapper.selectOne(pno);
		}
	}

	

}
