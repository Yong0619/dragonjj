package contents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MoviePaging;

@WebServlet("/contents/movieList.do")
public class MovieListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDAO dao = new ContentsDAO();
		HttpSession session = req.getSession();
		
		// 페이징 처리

		Map<String, Object> map = new HashMap<>();
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		if (searchWord != null) {
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		String sort = req.getParameter("sort");
		if (sort != null) {
			map.put("sort", sort);
		}

		// 게시물수
		int totalCount = dao.selectMovieCount(map);
		int pageSize = 5;
		int blockPage = 5;

		// 현재 페이지 확인
		int pageNum = 1;
		String pageTemp = req.getParameter("pageNum");
		if (pageTemp != null && !pageTemp.equals("")) {
			// 요청받은 페이지로 수정
			pageNum = Integer.parseInt(pageTemp);
		}
		// 목록에 출력할 게시물 범위 계산
		// 첫 게시물 번호 (1페이지 1, 2페이지 11...)
		int start = (pageNum - 1) * pageSize + 1;
		// 마지막 게시물 번호
		int end = pageNum * pageSize;
		map.put("start", start);
		map.put("end", end);

		// 페이징 처리 end
		String id = (String) session.getAttribute("UserId");
		String UserName = (String) session.getAttribute("UserName");
		List<ContentsDTO> molists = dao.getMovieList(map);
		dao.close();

		String pagingStr = MoviePaging.pagingstr(totalCount, pageSize, 
				blockPage, pageNum, "./movieList.do", sort);
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);

		req.setAttribute("molists", molists);
		req.setAttribute("map", map);
		req.setAttribute("id", id);
		req.setAttribute("UserName", UserName);
		req.getRequestDispatcher("/contents/hdmovielist.jsp").forward(req, resp);

	}

}
