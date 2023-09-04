package contents;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import common.JDBCConnect;

public class ContentsDAO extends JDBCConnect {
	// 드라마 등록
	public int insertDrama(ContentsDTO dto) {
		int result = 0;
		String qurey = "insert into contents(idx, title, ofile, sfile, episode, releasedate, age, cast, content, genre, price, youtube, category)"
				+ " values(seq_table_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = con.prepareStatement(qurey);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			psmt.setString(4, dto.getEpisode());
			psmt.setString(5, dto.getReleasedate());
			psmt.setString(6, dto.getAge());
			psmt.setString(7, dto.getCast());
			psmt.setString(8, dto.getContent());
			psmt.setString(9, dto.getGenre());
			psmt.setString(10, dto.getPrice());
			psmt.setString(11, dto.getYoutube());
			psmt.setString(12, dto.getCategory());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 영화 등록
	public int insertMovie(ContentsDTO dto) {
		int result = 0;
		String qurey = "insert into contents(idx, title, ofile, sfile, releasedate, time, age, director, cast, content, genre, price, youtube, category)"
				+ " values(seq_table_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = con.prepareStatement(qurey);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			psmt.setString(4, dto.getReleasedate());
			psmt.setString(5, dto.getTime());
			psmt.setString(6, dto.getAge());
			psmt.setString(7, dto.getDirector());
			psmt.setString(8, dto.getCast());
			psmt.setString(9, dto.getContent());
			psmt.setString(10, dto.getGenre());
			psmt.setString(11, dto.getPrice());
			psmt.setString(12, dto.getYoutube());
			psmt.setString(13, dto.getCategory());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 음악 등록
	public int insertMusic(ContentsDTO dto) {
		int result = 0;
		String qurey = "insert into contents(idx, album, title, ofile, sfile, artist, releasedate, time, lyrics, genre, price, youtube, category)"
				+ " values(seq_table_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			psmt = con.prepareStatement(qurey);
			psmt.setString(1, dto.getAlbum());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getArtist());
			psmt.setString(6, dto.getReleasedate());
			psmt.setString(7, dto.getTime());
			psmt.setString(8, dto.getLyrics());
			psmt.setString(9, dto.getGenre());
			psmt.setString(10, dto.getPrice());
			psmt.setString(11, dto.getYoutube());
			psmt.setString(12, dto.getCategory());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 인덱스 영화 목록 가져오기
	public List<ContentsDTO> movielist() {
		List<ContentsDTO> molist = new ArrayList<>();
		String query = "select * from contents where category = '영화'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				molist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return molist;
	}

	// 인덱스 드라마 목록 가져오기
	public List<ContentsDTO> dramalist() {
		List<ContentsDTO> drlist = new ArrayList<>();
		String query = "select * from contents where category = '드라마' and episode = 1";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				drlist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return drlist;
	}

	// 인덱스 음악 목록 조회
	public List<ContentsDTO> musiclist() {
		List<ContentsDTO> mulist = new ArrayList<>();
		String query = "select * from contents where category = '음악'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				mulist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mulist;
	}

	// 검색 조건에 맞는 영화 게시글의 개수 반환하기
	public int selectMovieCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = "select count(*) from contents where category='영화'";
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}

	// 검색 조건에 맞는 드라마 게시글의 개수 반환하기
	public int selectDramaCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = "select count(*) from contents where category='드라마' and episode=1";
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}

	// 검색 조건에 맞는 드라마 에피소드 게시글의 개수 반환하기
	public int selectDramaEpisodeCount(Map<String, Object> map, String title) {
		int totalCount = 0;
		String query = "select count(*) from contents where title='" + title + "'";
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}

	// 검색 조건에 맞는 음악 게시글의 개수 반환하기
	public int selectMusicCount(Map<String, Object> map) {
		int totalCount = 0;
		String query = "select count(*) from contents where category='음악'";
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCount;
	}

	// 영화 목록 가져오기
	public List<ContentsDTO> getMovieList(Map<String, Object> map) {
		List<ContentsDTO> molists = new ArrayList<ContentsDTO>();
		String query = "select * from ( select Tb.*,  rownum as rnum from"
				+ "(select * from contents where category='영화'";
		// map에 검색어가 있을경우
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		// map에 정렬기준이 있을경우
		if (map.get("sort") != null) {
			query += " order by " + map.get("sort") + " )";
		} else if (map.get("sort") == null) {
			query += " order by releasedate desc )";
		}
		query += " Tb ) where rnum between ? and ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				molists.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return molists;
	}

	// 드라마 목록 가져오기
	public List<ContentsDTO> getDramaList(Map<String, Object> map) {
		List<ContentsDTO> drlists = new ArrayList<ContentsDTO>();
		String query = "select * from (" + "select Tb.*,  rownum as rnum from"
				+ "(select * from contents where category='드라마' and episode=1";
		// map에 검색어가 있을경우
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		// map에 정렬기준이 있을경우
		if (map.get("sort") != null) {
			query += " order by " + map.get("sort") + " )";
		} else if (map.get("sort") == null) {
			query += " order by releasedate desc )";
		}
		query += " Tb ) where rnum between ? and ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				drlists.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drlists;
	}

	// 드라마 에피소드 목록 가져오기
	public List<ContentsDTO> getDramaEpisodeList(Map<String, Object> map, String title) {
		List<ContentsDTO> dreplists = new ArrayList<ContentsDTO>();
		String query = "select * from (" + "select Tb.*,  rownum as rnum from"
				+ "(select * from contents where category='드라마' and title=?";
		// map에 검색어가 있을경우
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		// map에 정렬기준이 있을경우
		if (map.get("sort") != null) {
			query += " order by " + map.get("sort") + " )";
		} else if (map.get("sort") == null) {
			query += " order by releasedate desc )";
		}
		query += " Tb ) where rnum between ? and ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, title);
			psmt.setString(2, map.get("start").toString());
			psmt.setString(3, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				dreplists.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dreplists;
	}

	// 음악 목록 가져오기
	public List<ContentsDTO> getMusicList(Map<String, Object> map) {
		List<ContentsDTO> molists = new ArrayList<ContentsDTO>();
		String query = "select * from (" + "select Tb.*,  rownum as rnum from"
				+ "(select * from contents where category='음악'";
		// map에 검색어가 있을경우
		if (map.get("searchWord") != null) {
			query += " and " + map.get("searchField") + " like '%" + map.get("searchWord") + "%'";
		}
		// map에 정렬기준이 있을경우
		if (map.get("sort") != null) {
			query += " order by " + map.get("sort") + " )";
		} else if (map.get("sort") == null) {
			query += " order by releasedate desc )";
		}
		query += " Tb ) where rnum between ? and ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				molists.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return molists;
	}

	// 구매 횟수 업데이트
	public void updatePurchaseCount(String idx) {
		int result = 0;
		String query = "update contents set purchasecount = purchasecount+1 where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 영화 상세 페이지
	public ContentsDTO selectMovie(String idx, String title) {
		ContentsDTO dto = new ContentsDTO();
		String query = "select * from contents where idx=? and title=? and category='영화'";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.setString(2, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	// 드라마 상세 페이지
	public ContentsDTO selectDrama(String idx, String title) {
		ContentsDTO dto = new ContentsDTO();
		String query = "select * from contents where idx=? and title=? and category='드라마'";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.setString(2, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	// 에피소드 불러오기
	public List<ContentsDTO> episodelist(Map<String, Object> map, String title) {
		List<ContentsDTO> mlist = new ArrayList<>();
		String query = "select * from (" + "select Tb.*,  rownum as rnum from"
				+ "(select * from contents where category='드라마' and title=?" + " order by LPAD(episode, 2, '0' )) Tb"
				+ ") where rnum between ? and ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, title);
			psmt.setString(2, map.get("start").toString());
			psmt.setString(3, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ContentsDTO dto = new ContentsDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
				mlist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}

	// 음악 상세 페이지
	public ContentsDTO selectMusic(String idx, String title) {
		ContentsDTO dto = new ContentsDTO();
		String query = "select * from contents where idx=? and title=? and category='음악'";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.setString(2, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAlbum(rs.getString(3));
				dto.setEpisode(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setRate(rs.getString(7));
				dto.setReleasedate(rs.getString(8));
				dto.setTime(rs.getString(9));
				dto.setAge(rs.getString(10));
				dto.setDirector(rs.getString(11));
				dto.setArtist(rs.getString(12));
				dto.setCast(rs.getString(13));
				dto.setContent(rs.getString(14));
				dto.setLyrics(rs.getString(15));
				dto.setGenre(rs.getString(16));
				dto.setCategory(rs.getString(17));
				dto.setPrice(rs.getString(18));
				dto.setYoutube(rs.getString(19));
				dto.setPurchasecount(rs.getString(20));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	// 영화 정보 수정하기
	public int movieEdit(ContentsDTO dto) {
		int result = 0;
		String query = "update contents set title=?, ofile=?, sfile=?, releasedate=?, time=?, "
				+ "age=?, director=?, cast=?, content=?, genre=?, category=?, price=?, youtube=? where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			psmt.setString(4, dto.getReleasedate());
			psmt.setString(5, dto.getTime());
			psmt.setString(6, dto.getAge());
			psmt.setString(7, dto.getDirector());
			psmt.setString(8, dto.getCast());
			psmt.setString(9, dto.getContent());
			psmt.setString(10, dto.getGenre());
			psmt.setString(11, dto.getCategory());
			psmt.setString(12, dto.getPrice());
			psmt.setString(13, dto.getYoutube());
			psmt.setString(14, dto.getIdx());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 드라마 정보 수정하기
	public int dramaEdit(ContentsDTO dto) {
		int result = 0;
		String query = "update contents set title=?, ofile=?, sfile=?, releasedate=?, episode=?, "
				+ "age=?, cast=?, content=?, genre=?, category=?, price=?, youtube=? where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			psmt.setString(4, dto.getReleasedate());
			psmt.setString(5, dto.getEpisode());
			psmt.setString(6, dto.getAge());
			psmt.setString(7, dto.getCast());
			psmt.setString(8, dto.getContent());
			psmt.setString(9, dto.getGenre());
			psmt.setString(10, dto.getCategory());
			psmt.setString(11, dto.getPrice());
			psmt.setString(12, dto.getYoutube());
			psmt.setString(13, dto.getIdx());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 음악 정보 수정하기
	public int musicEdit(ContentsDTO dto) {
		int result = 0;
		String query = "update contents set title=?, ofile=?, sfile=?, releasedate=?, album=?, "
				+ "artist=?, lyrics=?, genre=?, category=?, price=?, youtube=?, time=? where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getOfile());
			psmt.setString(3, dto.getSfile());
			psmt.setString(4, dto.getReleasedate());
			psmt.setString(5, dto.getAlbum());
			psmt.setString(6, dto.getArtist());
			psmt.setString(7, dto.getLyrics());
			psmt.setString(8, dto.getGenre());
			psmt.setString(9, dto.getCategory());
			psmt.setString(10, dto.getPrice());
			psmt.setString(11, dto.getYoutube());
			psmt.setString(12, dto.getTime());
			psmt.setString(13, dto.getIdx());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
