package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utills.DBConn;
import vo.Member;
import vo.Member.M;

//데이터 베이스 관련 작업은 여기서
public class MemberDao { 
	//CRUD 인설트하기
	public int insert(Member member) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");//drive를 쓰고 자동완성되는걸 붙여 넣는다
//			String sql = "INSERT  INTO tbl_member (id,pw,name) values ('"+member.getEmail()
//			+"','"+member.getPw()+ "','"+member.getName()+"')";
			
			String sql = "INSERT  INTO tbl_member (id,pw,name,email,road_addr,detail_addr) values (?,?,?,?,?,?)";//컬럼갯수와 지시자 갯수 일치해야함 
			
			//1.connection 객체 취득
			conn = DBConn.getConnection();//데이터 베이스 연결하기
			//2.문장 생성,파라미터 지정
//			Statement stmt = conn.createStatement();
			pstmt= conn.prepareStatement(sql); //프리페어드할때 미리 문장을 뗴어온다 statement 생성
			
			int idx =1;
			
			pstmt.setString(idx++, member.getId());
			pstmt.setString(idx++, member.getPw());
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getEmail());
			pstmt.setString(idx++, member.getRoadAddr());
			pstmt.setString(idx++, member.getDetailAddr());
			//3.문장 실행 select이냐 아니냐
//			return stmt.executeUpdate(sql);

			return pstmt.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			try {
				pstmt.close();//연결 해제 
				conn.close();//연결 해제 이거 꼭 해야함
			} catch (SQLException ignore) {}
		}
		
		return 0;
	}
	public static void main(String[] args) {
		MemberDao dao= new MemberDao();
		int result=	dao.insert(Member.builder().id("eeeeee").pw("1234").name("qqqww").build());
		System.out.println(result);
		
		Member m = dao.selectOne("ccaaacc");
				System.out.println(m);
		
	}
	private static final MemberDao dao = new MemberDao(); //싱글턴은 스태틱으로 만들어야함 제일 오래 살아남으면서 선언될때 생성이된다 
	
	
	public static MemberDao getInstance() {
		// TODO Auto-generated method stub
		return dao;
	}
	private MemberDao() {}//여기서만 쓸수있는 생성자 
	
	
	public Member selectOne(String id) {
		Member member = null;
		String sql ="select * from tbl_member where id =?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {//다음 행이 있다 없다
				member = Member.builder()
						.id(rs.getString("id"))//회원이 찾았을때있으면 여기까지옴
						.pw(rs.getString("pw"))
						.name(rs.getString("name"))
						.email(rs.getString("email"))
						.roadAddr(rs.getString("road_Addr"))
						.detailAddr(rs.getString("detail_Addr"))
						.regdate(rs.getDate("regdate"))
						.build();
						
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
}
