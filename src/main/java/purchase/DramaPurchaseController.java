package purchase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import contents.ContentsDAO;
import contents.ContentsDTO;

@WebServlet("/contents/dramapurchase.do")
public class DramaPurchaseController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDAO dao = new ContentsDAO();
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		String episode = req.getParameter("episode");
		ContentsDTO dto = dao.selectDrama(idx,title);
		dao.close();
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/contents/dramapurchase.jsp?idx"+idx+"&&title="+title+"&&episode="+episode).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		String episode = req.getParameter("episode");
		String id = (String) session.getAttribute("UserId");
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setTitle(title);
		dto.setIdx(idx);
		dto.setEpisode(episode);
		dto.setId(id);
		
		PurchaseDAO dao = new PurchaseDAO();
		int result = dao.dramaPurchase(dto);
		dao.close();
		
		if(result == 1) {
			ContentsDAO countupdate = new ContentsDAO();
			countupdate.updatePurchaseCount(idx);
			countupdate.close();
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('구매가 완료되었습니다.'); "
					+ "location.href='./dramaview.do?idx="+idx+"&&title="+title+"&&episode="+episode+"'</script>";
			write.print(script);
			write.close();
		} else {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('구매하지 못하였습니다.'); "
					+ "location.href = document.referrer;</script>";
			write.print(script);
			write.close();

		}
	}
	
	
	
}
