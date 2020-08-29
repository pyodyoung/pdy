package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ReadDao;
import model.Bbs;

@Controller
public class ReadController {
	@Autowired
	private ReadDao readDao;
	
	@RequestMapping(value="/read/readDetail.html")
	public ModelAndView readDetail(Integer SEQNO) {
		ModelAndView mav = new ModelAndView("home/template");
		//SEQNO에 있는 글번호로 DB검색
		Bbs bbs = readDao.getBbsDetail(SEQNO);
		//검색결과를 ModelAndView에 주입
		mav.addObject("BBS_ITEM",bbs);
		//ModelAndView에 뷰이름(JSP) 설정
		mav.addObject("BODY","bbsReadView.jsp");
		return mav;
	}
	
	@RequestMapping(value="read/read.html")
	public ModelAndView readBbs(Integer PAGENO) {
		ModelAndView mav = new ModelAndView("home/template");
		if(PAGENO == null) PAGENO = 1;
//		List<Bbs> bbsList = readDao.readBbs();//DB에서 모든 게시글 검색
		List<Bbs> bbsList = readDao.read5Bbs(PAGENO);//5개 게시글만 검색
		int totalCnt = readDao.getBbsCount();//전체 글의 갯수 검색
		int pageCnt = 0;//페이지 갯수
		if(totalCnt > 0) {
			pageCnt = totalCnt / 5;
			if(totalCnt % 5 > 0) pageCnt++;
		}
		mav.addObject("PAGE_CNT", pageCnt);
		mav.addObject("BBS_LIST",bbsList);
		mav.addObject("BODY","bbsListView.jsp");
		return mav;
	}
}

















