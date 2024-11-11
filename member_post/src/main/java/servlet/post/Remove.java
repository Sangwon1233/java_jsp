package servlet.post;

import java.io.IOException;


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

@WebServlet("/post/remove")
public class Remove extends HttpServlet{
    private PostService service = new PostServiceimpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pnoStr = req.getParameter("pno");
        Object memberObj = req.getSession().getAttribute("member");
        Criteria cri = new Criteria(req);
        String redirectUrl="list?" + cri.getQs2();
        
        if(pnoStr == null || memberObj == null) {
            Commons.printMsg("비정상적인 접근입니다", redirectUrl, resp);
            return;
        }
        Long pno = Long.valueOf(pnoStr);
        Member m = (Member) memberObj;
        if(!m.getId().equals(service.findBy(pno).getWriter())) {
            Commons.printMsg("본인이 작성한 글만 삭제할 수 있습니다.", redirectUrl, resp);
            return;
        }
        service.remove(pno);
        
//        resp.sendRedirect("list" + "?" + cri.getQs2());

        resp.sendRedirect(redirectUrl);
    }


}