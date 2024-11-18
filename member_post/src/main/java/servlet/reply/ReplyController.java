package servlet.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.ReplyService;
import service.ReplyServiceImpl;
import vo.Reply;

@WebServlet("/reply/*")//이 서블릿이 다 받는다
public class ReplyController extends HttpServlet {
	private ReplyService Service = ReplyServiceImpl.getInstance(); 
	private Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd-HH:mm:ss").create();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath() + "/reply/", "");
//		System.out.println(uri);
		
		
		Object ret =null;
		if(uri.startsWith("list")) {//목록조회
			int tmpIdx=uri.lastIndexOf("/");
			Long pno = 0L;
			if(tmpIdx != -1) {
				pno = Long.valueOf(uri.substring(tmpIdx+1));
			}
			ret=Service.list(pno);
		}
		else {//단일조회
			Long rno = Long.valueOf(uri);
			ret=Service.findBy(rno);
		}
		resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().print(gson.toJson(ret));
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Service.write(gson.fromJson(req.getReader(), Reply.class));
//		System.out.println("replyController.doPost()");
//		char[] chs=new char[req.getContentLength()];
//		req.getReader().read(chs);//문자배열은 문자열
//		String str = new String(chs);
//		System.out.println(str);
//		
////		JsonNode node = mapper.readTree(str);
////		System.out.println(node);
//		Reply reply=gson.fromJson(str, Reply.class);
//		System.out.println(reply);
//		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply= gson.fromJson(req.getReader(), Reply.class);
		System.out.println(reply);
		Service.modify(reply);
//		Reply reply=mapper.convertValue(str, Reply.class);
//		System.out.println(reply);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath() + "/reply/", "");	

		if(uri.startsWith("list")) {//다지울거냐
			int tmpIdx=uri.lastIndexOf("/");
			Long pno = 0L;
			if(tmpIdx != -1) {
				pno = Long.valueOf(uri.substring(tmpIdx+1));
			}
			Service.removeAll(pno);
		}
		else {//하나만 지울거냐
			Long rno = Long.valueOf(uri);
			Service.remove(rno);
		}

	}
	
	
}
