package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.WriteDao;
import model.Bbs;
import model.User;

@Controller
public class HomeController {
	@Autowired
	private WriteDao writeDao;
	
	@RequestMapping(value="/home/userentry.html")
	public ModelAndView userEntry() {
		ModelAndView mav = new ModelAndView("user/userentry"); //설정해주는 어디로 가는지
		mav.addObject(new User());//User 객체 주입                       뷰를 뿌리면서 값도 같이 가져가라
		mav.addObject("BODY","userentry.jsp");
		String a="다영바보";
		mav.addObject("Dayoung",a);
		return mav;
	}
	
	@RequestMapping(value="/home/write.html",method=RequestMethod.POST)
	public ModelAndView upload(@Valid Bbs bbs, BindingResult bindingResult,
			HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY","inputBBS.jsp");
			return mav;
		}
		String id = (String)session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		if(id == null) {//로그인을 안 한 경우
			mav.addObject("RESULT","nomember");
			//nologin.jsp에 객체(User)주입
			mav.addObject(new User());
			mav.addObject("BODY","nologin.jsp");//nologin.jsp를 출력
			return mav;
		}else {//로그인을 한 경우
			bbs.setId(id);//계정을 설정
			//DAO를 이용하여 삽입
			writeDao.insertBBS(bbs);
			return new ModelAndView("redirect:/read/read.html");
		}
	}
	
	@RequestMapping(value="/home/bbsTemplate.html")
	public ModelAndView bbsInput() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Bbs());//폼폼에 객체 주입
		mav.addObject("BODY","inputBBS.jsp");
		return mav;
	}
	
	@RequestMapping(value="/home/intro.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY",BODY);
		return mav;
	}
}
























