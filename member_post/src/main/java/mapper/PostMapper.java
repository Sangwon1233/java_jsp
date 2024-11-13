package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dto.Criteria;
import vo.Post;


public interface PostMapper {
	 int insert(Post post);

	 Post selectOne(Long pno);
    
	 public int getCount(Criteria cri);
	 
	 public List<Post> selectList(Criteria cri);
	 
	 public int update(Post post);
	 
	 int delete(Long pno);
	 
	 int increaseViewCount(Long pno);
}