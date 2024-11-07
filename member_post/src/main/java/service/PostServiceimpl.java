package service;

import java.util.List;

import dao.PostDao;
import vo.Post;

public class PostServiceimpl implements PostService  {
	private PostDao dao = new PostDao();
	
	
	public int write(Post post) {
		return dao.insert(post); 
	};
	
	public int modify(Post post) {
		return dao.update(post);
	};
	
	public int romove(Long pno) {
		return dao.delete(pno);
	};
	
	public Post findBy(Long pno) {
		return dao.selectOne(pno);
	};
	
	public List<Post> list(){
		return dao.selectList();
	};
	
	

}
