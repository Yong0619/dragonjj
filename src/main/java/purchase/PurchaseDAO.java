package purchase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCConnect;

public class PurchaseDAO extends JDBCConnect {
	// 드라마 구매
	public int dramaPurchase(PurchaseDTO dto) {
		int result = 0;
		String query = "insert into purchase(idx, title, id, episode, postdate) " + "values(?, ?, ?, ?, sysdate)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getId());
			psmt.setString(4, dto.getEpisode());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 드라마 구매 여부 반환
	public int dramaPurchasecheck(String id, String title, String episode) {
		int result = 0;
		String query = "select count(*) from purchase where id=? and title=? and episode=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, title);
			psmt.setString(3, episode);
			rs = psmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = 0;
			e.printStackTrace();
		}

		return result;
	}

	// 영화&음악 구매
	public int Purchase(PurchaseDTO dto) {
		int result = 0;
		String query = "insert into purchase(idx, title, id, postdate) " + "values(?, ?, ?, sysdate)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getId());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 영화&음악 구매 여부 반환
	public int Purchasecheck(String id, String title) {
		int result = 0;
		String query = "select count(*) from purchase where id=? and title=?";
		;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, title);
			rs = psmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = 0;
			e.printStackTrace();
		}

		return result;
	}

	// 구매목록 반환
	public List<PurchaseDTO> purchaseList(String id) {
		List<PurchaseDTO> plist = new ArrayList<>();
		String query = "select * from purchase where id=? order by postdate";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				PurchaseDTO dto = new PurchaseDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setTitle(rs.getString("title"));
				dto.setEpisode(rs.getString("episode"));
				dto.setId(rs.getString("id"));
				dto.setPostdate(rs.getString("postdate"));
				plist.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plist;
	}
}
