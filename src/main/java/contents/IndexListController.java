package contents;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.do")
public class IndexListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDAO dao = new ContentsDAO();
		HttpSession session = req.getSession();
		
		List<ContentsDTO> molist = dao.movielist();
		List<ContentsDTO> drlist = dao.dramalist();
		List<ContentsDTO> mulist = dao.musiclist();
		
		dao.close();
		
		req.setAttribute("molist", molist);
		req.setAttribute("drlist", drlist);
		req.setAttribute("mulist", mulist);
		req.getRequestDispatcher("./index.jsp").forward(req, resp);
		
	}	
}
