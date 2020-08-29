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

	@RequestMapping(value="/home/write.html", method=RequestMethod.POST)
	public ModelAndView upload(@Valid Bbs bbs, BindingResult bindingResult,
			HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY","inputBBS.jsp");
			mav.getModel().putAll(bindingResult.getModel());
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
		ModelAndView mav=new ModelAndView("home/template");
		mav.addObject(new Bbs()); //form form에 객체 주입
		mav.addObject("BODY","inputBBS.jsp");
		return mav;
	}
	@RequestMapping(value="/home/intro.html")
	public ModelAndView intro(String BODY) {
		ModelAndView mav=new ModelAndView("home/template");
		mav.addObject("BODY",BODY);
		return mav;
	}
}
