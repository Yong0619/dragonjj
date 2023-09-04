package utils;

public class MusicPaging {
	public static String pagingstr(int totalCount, int pageSize,
			int blockPage, int pageNum, String reqUrl, String sort) {
		String pagingStr = "";
		
		//전체 페이지 수 =전체 레코드 수 / 한페이지당 레코드 수
		int totalpages = (int) Math.ceil ((double) totalCount / pageSize);
		//이전페이지 블록 바로가기
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		if(pageTemp != 1) {
			pagingStr += "<a href='"+reqUrl+"?pageNum=1&category=음악&sort="+sort+"'>[처음]</a>";
			pagingStr += "<a href='"+reqUrl+"?pageNum="
					+(pageTemp-1)+"&category=음악&sort="+sort+"'>[이전]</a>";
		}
		//각 페이지 번호 출력
		int blockcount= 1;
		while(blockcount <= blockPage && pageTemp <= totalpages) {
			//현재 페이지는 링크를 걸지 않음
			if(pageTemp == pageNum) {
				pagingStr += " "+pageTemp+" ";
			} else {
				pagingStr += "<a href='"+reqUrl+"?pageNum="
							+pageTemp+"&category=음악&sort="+sort+"'>"+pageTemp+"</a>";
			}
			pageTemp++;
			blockcount++;
		}
		//마지막 페이지, 다음블록 출력
		//pagaTemp가 전체 페이지수 이하일때 다음블록과 마지막 페이지 링크 출력
		if(pageTemp <= totalpages) {
			pagingStr += "<a href='"+reqUrl+"?pageNum="+pageTemp+"&category=음악&sort="+sort+"'>[다음]</a>";
			pagingStr += "<a href='"+reqUrl+"?pageNum="+totalpages+"&category=음악&sort="+sort+"'>[마지막]</a>";
		}
		return pagingStr;
	}
}
