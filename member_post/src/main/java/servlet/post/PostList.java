package servlet.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Criteria;
import dto.PageDto;
import service.PostService;
import service.PostServiceimpl;


@WebServlet("/post/list")
public class PostList extends HttpServlet {
	private PostService service=new PostServiceimpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Criteria cri = new Criteria(req);
		System.out.println(cri);
		req.setAttribute("posts", service.list(cri));
		req.setAttribute("pageDto", new PageDto(cri,service.count(cri)));
		req.getRequestDispatcher("/WEB-INF/jsp/post/list.jsp").forward(req, resp);
	}
	
	

}
