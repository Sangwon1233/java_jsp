package service;

import java.util.List;

import dto.Criteria;
import vo.Post;

public interface PostService {
	int write(Post post);
	
	int modify(Post post);
	
	int remove(Long pno);
	
	Post findBy(Long pno);
	
	Post view(Long pno);
	
	List<Post> list(Criteria cri);
	
	int count(Criteria cri);
	
	

	

}
