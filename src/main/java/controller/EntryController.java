package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EntryDao;
import dao.LoginDao;
import model.User;

@Controller
public class EntryController {
	@Autowired
	private EntryDao entryDao; //경로를 찾아주는 
	
	@RequestMapping(value="/entry/entry.html")
	public ModelAndView entry(User user, HttpSession session) { //폼안엥 ㅣㅇㅆ는 정보들을 유저라는 이름으로 모델 어트리 뷰트 컨트롤러로 보낸다고?)
		//가입 성공인경우 즉시 로그인상태로 전환
		//DB에 가입자 정보를 삽입(insert)한다.
		//->새로운 DAO를 작성?(김창민 팀장의 결정 사항)
		   System.out.println("======================");
		      System.out.println(user.getId());
		      System.out.println(user.getName());
		      System.out.println(user.getAddress());
		      System.out.println(user.getJob());
		      System.out.println(user.getPwd());
		      System.out.println(user.getGender());
		      System.out.println(user.getEmail());
		      System.out.println("======================");
		entryDao.entryUser(user);//DB에 가입자 삽입 //입력한 값들을 엔드리 다오로 보낸다. 
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
















