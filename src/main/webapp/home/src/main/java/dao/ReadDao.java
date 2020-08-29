package dao;

import java.util.List;

import model.Bbs;

public interface ReadDao {
	List<Bbs> readBbs();//전체 게시글 검색
	List<Bbs> read5Bbs(Integer p);//입력된 페이지에 해당하는 5개 글만 검색
	Bbs getBbsDetail(Integer seqno);//특정 게시글을 글번호로 검색
	Integer getBbsCount();
}
