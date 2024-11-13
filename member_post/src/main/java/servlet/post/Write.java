package servlet.post;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Criteria;
import service.PostService;
import service.PostServiceimpl;
import vo.Attach;
import vo.Post;

@WebServlet("/post/write")
public class Write extends HttpServlet  {
	private PostService postService=new PostServiceimpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Criteria cri = new Criteria(req);
			if (req.getSession().getAttribute("member")==null){
				String cp =req.getContextPath();
				resp.sendRedirect(cp + "/signin?url=" +
						URLEncoder.encode(cp + "/post/write?" + cri.getQs2(), "utf-8"));// 숫자가 없으면 괜찮은데 슬러시떔에 혹시 몰라 인코드하기
				return;
			}
			req.setAttribute("cri", cri);
			req.getRequestDispatcher("/WEB-INF/jsp/post/write.jsp").forward(req, resp);
		}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Criteria cri = new Criteria(req);
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			
			List<Attach> attachs = new ArrayList<>();
			
			//첨부파일 정보 수집
			String[] uuids= req.getParameterValues("uuid");//배열 수집
			String[] origins= req.getParameterValues("origin");//배열 수집
			String[] images= req.getParameterValues("image");//배열 수집
			String[] paths= req.getParameterValues("path");//배열 수집
			
			
			if(uuids != null){
				for(int i = 0; i <uuids.length; i++) {
					attachs.add(Attach.builder()
							.uuid(uuids[i])
							.origin(origins[i])
							.image(images[i].equals("true"))
							.path(paths[i])
							.build());
			
				}
			}
			postService.write(Post.builder().title(title).content(content).writer(writer).cno(cri.getCategory()).attachs(attachs).build());
			
			resp.sendRedirect("list?" + cri.getQs2());
		}
		
}
