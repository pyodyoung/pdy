package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EntryDao;
import model.User;

@Controller
public class EntryController {
	@Autowired
	private EntryDao entryDao;
	@RequestMapping(value="/entry/entry.html")
	public ModelAndView entry(User user, HttpSession session) {
		//가입 성공인경우 즉시 로그인상태로 전환
		//DB에 가입자 정보를 삽입(insert)한다.
		//->새로운 DAO를 작성?(김창민 팀장의 결정 사항)
		entryDao.entryUser(user);//DB에 가입자 삽입
		session.setAttribute("loginUser", user.getId());
		//첫화면으로 전환
		return new ModelAndView("redirect:/entry/home.html");
	}
	
	@RequestMapping(value="/entry/home.html")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","loginResult.jsp");
		return mav;
	}
	
}
















