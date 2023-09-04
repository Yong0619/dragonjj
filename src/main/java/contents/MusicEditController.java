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

@WebServlet("/contents/musicEdit.do")
public class MusicEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentsDAO dao = new ContentsDAO();
		
		String idx = req.getParameter("idx");
		String title = req.getParameter("title");
		
		// 음악 정보 반환
		ContentsDAO mudao = new ContentsDAO();
		ContentsDTO mulist = mudao.selectMusic(idx, title);
		mudao.close();
		
		req.setAttribute("mulist", mulist);
		req.getRequestDispatcher("/contents/musicedit.jsp").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		//1.파일 업로드 처리
		//업로드 디렉토리의 물리적 경로확인
		String saveDirectory = req.getServletContext().getRealPath("/uploads");
		//파일 크기 지정
		int maxPostSize = 1024*1000;
		//파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr == null) {
			//파일 업로드 실패
			return;
		}
		
		//파일 업로드 외 처리
		//수정내용을 매개변수에서 얻어옴
		String idx = mr.getParameter("idx");
		String title = mr.getParameter("title");
		String genre = mr.getParameter("genre");
		String releasedate = mr.getParameter("releasedate");
		String album = mr.getParameter("album");
		String artist = mr.getParameter("artist");
		String lyrics = mr.getParameter("lyrics");
		String price = mr.getParameter("price");
		String youtube = mr.getParameter("youtube");
		String category = mr.getParameter("category");
		
		//DTO에 저장하기
		ContentsDTO dto = new ContentsDTO();
		dto.setTitle(title);
		dto.setGenre(genre);
		dto.setReleasedate(releasedate);
		dto.setAlbum(album);
		dto.setArtist(artist);
		dto.setLyrics(lyrics);
		dto.setPrice(price);
		dto.setIdx(idx);
		dto.setYoutube(youtube);
		dto.setCategory(category);
		
		String fileName = mr.getFilesystemName("ofile");
		if(fileName != null) {
			//새로운 파일명 생성
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFileName = now + ext;
			
			//파일명 변경하기
			File oldFile = new File(saveDirectory+File.separator+fileName);
			File newFile = new File(saveDirectory+File.separator+newFileName);
			oldFile.renameTo(newFile);
			
			//DTO에 저장
			dto.setOfile(fileName);
			dto.setSfile(newFileName);
		}
		//데이터 베이스에 update 사용
		ContentsDAO dao = new ContentsDAO();
		int result = dao.musicEdit(dto);
		dao.close();
		
		if(result == 1) {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('음악 정보 수정이 완료되었습니다.'); "
					+ "location.href='./musicList.do'</script>";
			write.print(script);
			write.close();
		} else {
			PrintWriter write = resp.getWriter();
			String script = "<script>alert('음악 정보 수정을 실패했습니다.'); "
					+ "history.back();</script>";
			write.print(script);
			write.close();

		}
	}
	
}
