package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utills.DBConn;
import vo.Post;

public class PostDao {
	public int insert(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert 처리 행 갯수
		try {
			String sql = "insert into tbl_post (title, writer, content)" + " values ( ?, ?, ?)";

			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);

			int idx = 1;

			pstmt.setString(idx++, post.getTitle());
			pstmt.setString(idx++, post.getWriter());
			pstmt.setString(idx++, post.getContent());
			return pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) {
			}
		}

		return 0;
	}

	public Post selectOne(Long pno) {
		Post post = null;
		String sql = "select pno ,title,writer,content,view_count,regdate,updatedate  from tbl_post where pno =?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, pno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int idx = 1;

				post = Post.builder().pno(rs.getLong(idx++)).title(rs.getString(idx++)).writer(rs.getString(idx++))
						.content(rs.getString(idx++)).viewCount(rs.getLong(idx++)).regdate(rs.getDate(idx++))
						.updatedate(rs.getDate(idx++)).build();

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
	}

	public List<Post> selectList() {
		List<Post> posts = new ArrayList<>();
		
		String sql = "select pno ,tile,writer,viewcount,regedate from tbl_post";
		try (Connection conn = DBConn.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int idx = 1;

				Post post = Post.builder().pno(rs.getLong(idx++)).title(rs.getString(idx++)).writer(rs.getString(idx++))
						.viewCount(rs.getLong(idx++)).regdate(rs.getDate(idx++))
						.build();
				posts.add(post);

			}
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return posts;
		
	}

	public int update(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// insert 처리 행 갯수
		try {
//				String sql ="insert into tbl_member (id, pw, name) values ('" + member.getEmail()
//				+ "', '" + member.getPw() + "', '" + member.getName() + "')";

			String sql = "update tbl_post set title = ? , content = ?, updatedate = now() where pno = ?";

			// 1. connection 객체 취득
			conn = DBConn.getConnection();
			// 2. 문장 생성, 파라미터 지정
//				Statement stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);

			int idx = 1;

			pstmt.setString(idx++, post.getTitle());
			pstmt.setString(idx++, post.getContent());
			pstmt.setLong(idx++, post.getPno());
			return pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) {
			}
		}

		return 0;
	}

	public int delete(Long pno) {
		Connection conn = null;

		PreparedStatement pstmt = null;
		// insert 처리 행 갯수
		try {
//				String sql ="insert into tbl_member (id, pw, name) values ('" + member.getEmail()
//				+ "', '" + member.getPw() + "', '" + member.getName() + "')";

			String sql = "delete from tbl_post where pno=?";

			// 1. connection 객체 취득
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, pno);

			return pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException ignore) {
			}
		}

		return 0;

	}
	public static void main(String[] args) {
	    PostDao dao = new PostDao();
//	    for(int i= 0;i<10; i++) {
//	    	
//	    	dao.insert(Post.builder().writer("aa").title("제목+ " +(i+1)).content("내용").build());
//	    }
//	    dao.selectList().forEach(System.out::println);
//	    System.out.println(dao.selectOne(4L));
//	    System.out.println(dao.delete(4L));
	    
	    
	    
	    Post post = dao.selectOne(3L);
	    
	    System.out.println(post);
	    
	    post = Post.builder().pno(post.getPno()).title("수정된 제목").content("수정된 내용").build();
	    
	    dao.update(post);
	    
	    post = dao.selectOne(3L);
	    
	    System.out.println(post);
	}


}

