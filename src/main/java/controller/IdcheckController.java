package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;

@Controller
public class IdcheckController {
	@Autowired
	private LoginDao loginDao;
	@RequestMapping(value="/idcheck/idcheck.html")
	public ModelAndView idcheck(String ID) {
		ModelAndView mav = new ModelAndView("home/idCheck");//중복결과JSP
		//DB에서 ID에 있는 계정의 갯수를 검색한다. 0 이상이면 중복
		Integer cnt = loginDao.getIdCount(ID);
		if(cnt > 0) {//입력한 계정으로 이미 존재
			mav.addObject("DUP","YES");
		}else {//입력한 계정이 없는 경우
			mav.addObject("DUP","NO");
		}
		mav.addObject("ID",ID);
		return mav;
	}
}
















