package utills;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Commons {

    public static void printMsg(String msg, String url, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<script>");
        pw.printf("alert('%s'); %n", msg);
        pw.printf("location.href = '%s' ;%n", url);
        pw.println("</script>");

    }
}