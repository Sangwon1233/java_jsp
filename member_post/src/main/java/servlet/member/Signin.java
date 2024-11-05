package servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/signin")
public class Signin extends HttpServlet {
	private MemberService service = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");// 한글 깨짐 해결하기 위해 값 넣기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String saveid= req.getParameter("remember-id");
		System.out.println(saveid);
//		Member member =new Member(); //싱글턴
//		member.setId(id);
//		member.setPw(pw);

		System.out.println(id);
		System.out.println(pw);

//		service.register(member);
		if (service.login(id, pw)) {
			// 로그인성공
			HttpSession session = req.getSession();
			session.setAttribute("member", service.findBy(id));
			resp.sendRedirect(req.getContextPath()+"/index");
		}	// 슬러시는 루트
		else if(saveid.equals("yes")) {
			Cookie cookie =new Cookie(id, pw);
			System.out.println(cookie);
			cookie.setMaxAge(60*60*24);
	    	resp.addCookie(cookie);

	    	HttpSession session = req.getSession();
	    	session.setAttribute("member", service.findBy(id));
	    	resp.sendRedirect(req.getContextPath()+"/index");// 슬러시는 루트
		}	

		else {
			resp.sendRedirect("login?msg=fail");
			

		}

	}

}
