package pmember;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MemberPaging;

@WebServlet("/member/memberList.do")
public class MemberListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PmemberDAO dao = new PmemberDAO();
		
		List<PmemberDTO> mlist = dao.getMemberList();
		dao.close();
		
		req.setAttribute("memberlists", mlist);
		req.getRequestDispatcher("/member/memberlist.jsp").forward(req, resp);
		
	}
	
}
