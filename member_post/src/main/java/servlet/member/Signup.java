package servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //request가 요청 response 응답
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");//한글 깨짐 해결하기 위해 값 넣기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String roadAddr = req.getParameter("roadAddr");
		String detailAddr = req.getParameter("detailAddr");
		

//		Member member =new Member(); //싱글턴
//		member.setId(id);
//		member.setPw(pw);
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email)
				.roadAddr(roadAddr)
				.detailAddr(detailAddr)
				.build(); //빌더로 호출
		
		
		
		System.out.println(member);
		
		service.register(member);
		
		resp.sendRedirect("signup");
	
	}
	
	
}
