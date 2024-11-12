package service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import vo.Post;

public interface TestService {
	List<Post> list();
	
	Post findBy(Long pno);
	
	@Select("select now()")
	String now();
	
	int write(Post post);
	
}
