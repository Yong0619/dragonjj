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

import utils.DramaPaging;

@WebServlet("/contents/dramaEpisodeEdit.do")
public class DramaEpisodeEditController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//에피소드 목록 반환
		ContentsDAO elist = new ContentsDAO();
		HttpSession session = req.getSession();
		
		String title = req.getParameter("title");
		String idx = req.getParameter("idx");
		String id = (String) session.getAttribute("UserId");
		String UserName = (String) session.getAttribute("UserName");
		String sort = req.getParameter("sort");
		
		Map<String, Object> map = new HashMap<>();

		// 게시물수
		int totalCount = elist.selectDramaEpisodeCount(map, title);
		int pageSize = 10;
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
		
		List<ContentsDTO> episodelist = elist.episodelist(map, title);
		elist.close();
		
		String pagingStr = DramaPaging.pagingstr(totalCount, pageSize, 
				blockPage, pageNum, "./dramaEpisodeEdit.do", title, idx, sort);
		map.put("pagingStr", pagingStr);
		map.put("totalCount", totalCount);
		map.put("pageSize", pageSize);
		map.put("pageNum", pageNum);
		map.put("title", title);
		map.put("idx", idx);
		
		req.setAttribute("map", map);			
		req.setAttribute("id", id);			
		req.setAttribute("UserName", UserName);			
		req.setAttribute("episodelist", episodelist);			
		req.getRequestDispatcher("/contents/dramaeditbefore.jsp").forward(req, resp);
	}
	
}
