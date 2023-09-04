package contents;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;

@WebServlet("/contents/musicUpload.do")
public class MusicUploadController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/contents/upload.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		int maxPostSize = 1024*1000;
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr == null) {
			//파일 업로드 실패
			return;
		}
		ContentsDTO dto = new ContentsDTO();
		dto.setAlbum(mr.getParameter("album"));
		dto.setTitle(mr.getParameter("title"));
		dto.setArtist(mr.getParameter("artist"));
		dto.setReleasedate(mr.getParameter("releasedate"));
		dto.setTime(mr.getParameter("time"));
		dto.setLyrics(mr.getParameter("lyrics"));
		dto.setPrice(mr.getParameter("price"));
		dto.setYoutube(mr.getParameter("youtube"));
		dto.setGenre(mr.getParameter("genre"));
		dto.setCategory(mr.getParameter("category"));
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName!=null) {
			String now = new SimpleDateFormat("yyyyMMdd_hmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFilename = now + ext;
			
			//파일명 변경
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFilename);
			oldFile.renameTo(newFile);
			
			dto.setOfile(fileName);
			dto.setSfile(newFilename);
		}
		ContentsDAO dao = new ContentsDAO();
		int result = dao.insertMusic(dto);
		dao.close();
		
		if(result == 1) {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('음악 등록이 완료되었습니다.'); "
					+ "location.href = document.referrer;</script>";
			write.print(script);
			write.close();
		} else {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('등록 실패하였습니다.'); "
					+ "location.href = document.referrer;</script>";
			write.print(script);
			write.close();

		}
	}
	
	
}
