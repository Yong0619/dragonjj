package contents;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import purchase.PurchaseDAO;
import review.ReviewDAO;
import review.ReviewDTO;

@WebServlet("/contents/movieview.do")
public class MovieViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		String id = (String) session.getAttribute("UserId");
		
		//영화 정보 반환
		ContentsDAO dao = new ContentsDAO();
		ContentsDTO dto = dao.selectMovie(idx, title);
		dao.close();
		
		//영화 리뷰 반환
		ReviewDAO muReview = new ReviewDAO();
		List<ReviewDTO> review = muReview.getReview(title);
		muReview.close();
		
		//구매여부체크
		PurchaseDAO pdao = new PurchaseDAO();
		int result = pdao.Purchasecheck(id, title);
		pdao.close();
		
		req.setAttribute("dto", dto);
		req.setAttribute("review", review);
		req.setAttribute("id", id);	
		req.setAttribute("result", result);			
		req.getRequestDispatcher("/contents/moviedetailpage.jsp").forward(req, resp);
	}
	
}
