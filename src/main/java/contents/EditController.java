package contents;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contents/edit.do")
public class EditController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDAO dao = new ContentsDAO();
		
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		
		// 영화 정보 반환
		ContentsDAO modao = new ContentsDAO();
		ContentsDTO molist = modao.selectMovie(idx, title);
		modao.close();
		// 드라마 정보 반환
		ContentsDAO drdao = new ContentsDAO();
		ContentsDTO drlist = drdao.selectDrama(idx, title);
		drdao.close();
		// 음악 정보 반환
		ContentsDAO mudao = new ContentsDAO();
		ContentsDTO mulist = mudao.selectMusic(idx, title);
		mudao.close();
		
		req.setAttribute("molist", molist);
		req.setAttribute("drlist", drlist);
		req.setAttribute("mulist", mulist);
		req.getRequestDispatcher("/contents/edit.jsp").forward(req, resp);
	
	}
}
