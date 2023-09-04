package pmember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.SHA256;

import javax.servlet.ServletRequest;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//선연결
		PmemberDAO dao = new PmemberDAO();
		//세션생성
		HttpSession session = req.getSession();
		//인코딩
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String inputpass = req.getParameter("inputpass");
		String pass = SHA256.encodeSha256(inputpass);
		
		
		PmemberDTO dto = dao.getMember(id,pass);
		
		if(dto.getId() != null) {
			session.setAttribute("UserId", dto.getId());
			session.setAttribute("UserName", dto.getName());
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('로그인 되었습니다.'); "
					+ "location.href='../index.do'</script>";
			write.print(script);
			write.close();
		} else {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('로그인 실패. 아이디 / 비밀번호를 확인하세요.'); "
					+ "location.href='../index.do'</script>";
			write.print(script);
			write.close();
		}
	}
	
	
}
