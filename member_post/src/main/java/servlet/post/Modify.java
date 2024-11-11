package servlet.post;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Criteria;
import service.PostService;
import service.PostServiceimpl;
import utills.Commons;
import vo.Member;
import vo.Post;

@WebServlet("/post/modify")
public class Modify extends HttpServlet {
	private PostService Service = new PostServiceimpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoStr = req.getParameter("pno");
		Object memberObj = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		  String redirectUrl="list?"+cri.getQs2();

		if (pnoStr == null || memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다", "list?"+cri.getQs2(), resp);
			return;
		}
		Long pno = Long.valueOf(pnoStr);
		Member m = (Member) memberObj;
		if (!m.getId().equals(Service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 삭제할 수 있습니다.","list?"+cri.getQs2(), resp);
			return;
		}
		req.setAttribute("cri", cri);
		req.setAttribute("post", Service.findBy(pno));
		req.getRequestDispatcher("/WEB-INF/jsp/post/modify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object memberObj = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		
		if (memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다", "list?"+cri.getQs2(), resp);//페이지까지 같이보내는건 qs2
			return;
		}
		
		Member m = (Member) memberObj;
		// 파라미터 수집
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String pnoStr = req.getParameter("pno");
		Long pno = Long.valueOf(pnoStr);
		
		
		if (!m.getId().equals(Service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 수정할 수 있습니다.", "list?"+cri.getQs2(), resp);
			return;
		}

		Service.modify(Post.builder().title(title).content(content).pno(pno).build());
		resp.sendRedirect("view?pno=" + pno+"&"+cri.getQs2());

	}

}
