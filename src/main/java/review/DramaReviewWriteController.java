package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/contents/dramareviewwrite.do")
public class DramaReviewWriteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReviewDTO dto = new ReviewDTO();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String id = (String) session.getAttribute("UserId");
		String idx = req.getParameter("idx");
		String episode = req.getParameter("episode");
		
		ReviewDAO dao = new ReviewDAO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setId(id);
		dto.setEpisode(episode);
		
		int result = dao.insertDramaReview(dto);
		dao.close();
		
		if(result == 1) {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('감상평이 등록되었습니다.'); "
					+ "location.href='/project01/contents/dramaview.do?idx="+idx+"&&title="+title+"&&episode="+episode+"'</script>";
			write.print(script);
			write.close();
		} else {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('감상평 등록이 실패했습니다'); "
					+ "location.href='/project01/contents/dramaview.do?idx="+idx+"&&title="+title+"&&episode="+episode+"'</script>";
			write.print(script);
			write.close();
		}
	}
	
}