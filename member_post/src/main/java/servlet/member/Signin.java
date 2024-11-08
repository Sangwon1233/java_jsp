package servlet.member;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import service.MemberServiceImpl;


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
		String saveid = req.getParameter("remember-id");
		System.out.println(saveid);

//		rMember member =new Member(); //싱글턴
//	
//		member.setId(id);
//		member.setPw(pw);

		System.out.println(id);
		System.out.println(pw);
		System.out.println(saveid);

//		service.register(member);
		if (service.login(id, pw)) {
			// 로그인성공
			HttpSession session = req.getSession();
			session.setAttribute("member", service.findBy(id));

			// 쿠키에 아이디 기억 여부 처리
			if (saveid != null) {
				Cookie cookie = new Cookie("remember-id", id);// 앞에는 이름
				cookie.setMaxAge(60 * 60 * 24 * 7);// 일주일 동안
				resp.addCookie(cookie);

			} else {
				// 아이디 기억 안할 때 처리할 일
				Cookie[] cookies = req.getCookies();
				for (Cookie c : cookies) {
					if (c.getName().equals("remember-id")) {
						c.setMaxAge(0);
						resp.addCookie(c);
						break;
					}
				}
			}

			// url 파라미터 여부에 따른 리디렉션 페이지 지정
			String redirectURL = req.getContextPath() + "/index";
			String url = req.getParameter("url");
			if (url != null && !url.equals("")) {
				redirectURL = URLDecoder.decode(url, "utf-8");
			}
			resp.sendRedirect(redirectURL);
		} else {
			resp.sendRedirect("login?msg=fail");
		}

	}

}

// 슬러시는 루트
//		else if(saveid.equals("yes")) {
//			Cookie cookie =new Cookie(id, pw);
//			System.out.println(cookie);
//			cookie.setMaxAge(60*60*24);
//	    	resp.addCookie(cookie);
//
//	    	HttpSession session = req.getSession();
//	    	session.setAttribute("member", service.findBy(id));
//	    	resp.sendRedirect(req.getContextPath()+"/index");// 슬러시는 루트
//		}	
//
