package review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCConnect;

public class ReviewDAO extends JDBCConnect {
	// 드라마 리뷰 등록
	public int insertDramaReview(ReviewDTO dto) {
		int result = 0;
		String query = "insert into review(idx, title, id, episode, content, postdate) "
				+ "values(seq_table_num.nextval, ?, ?, ?, ?, sysdate)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getEpisode());
			psmt.setString(4, dto.getContent());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 영화&음악 리뷰 등록
	public int insertReview(ReviewDTO dto) {
		int result = 0;
		String query = "insert into review(idx, title, id, content, postdate) "
				+ "values(seq_table_num.nextval, ?, ?, ?, sysdate)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getContent());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 드라마 리뷰 목록 반환
	public List<ReviewDTO> getDramaReview(String title, String episode) {
		List<ReviewDTO> dramareviewlist = new ArrayList<>();
		String query = "select * from review where title=? and episode=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, title);
			psmt.setString(2, episode);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setEpisode(rs.getString("episode"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dramareviewlist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dramareviewlist;
	}

	// 영화&음악 리뷰 목록 반환
	public List<ReviewDTO> getReview(String title) {
		List<ReviewDTO> reviewlist = new ArrayList<>();
		String query = "select * from review where title=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setEpisode(rs.getString("episode"));
				dto.setId(rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				reviewlist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviewlist;
	}

	// 리뷰 삭제
	public int deleteReview(String idx) {
		int result = 0;
		String query = "delete from review where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
