package service;

import java.util.List;

import dao.PostDao;
import dto.Criteria;
import vo.Post;

public class PostServiceimpl implements PostService  {
	private PostDao dao = new PostDao();
	
	
	public int write(Post post) {
		return dao.insert(post); 
	};
	
	public int modify(Post post) {
		return dao.update(post);
	};
	
	public int remove(Long pno) {
		return dao.delete(pno);
	};
	
	public Post findBy(Long pno) {
		return dao.selectOne(pno);
	};
	
	public List<Post> list(Criteria cri){
		return dao.selectList(cri);
	}
	

	@Override
	public int count(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.getCount(cri);
	}

	@Override
	public Post view(Long pno) {
		dao.increaseViewCount(pno);
		return findBy(pno);
	}

	

}
