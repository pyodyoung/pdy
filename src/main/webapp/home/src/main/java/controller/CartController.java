package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.Cart;
import model.User;

@Controller
public class CartController {
	@Autowired
	LoginDao loginDao;
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/cart/login.html",method=RequestMethod.POST)
	public ModelAndView cartLogin(@Valid User user, BindingResult bindingResult, HttpSession session){
		if(bindingResult.hasErrors()) {
			ModelAndView mav=new ModelAndView("home/cartLogin");
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		User loginUser=loginDao.findByIdAndPwd(user); //DB다녀오기
		if(loginUser != null) {//로그인 성공
			session.setAttribute("loginUser", user.getId());//세션에 저장
			mav.addObject("cartLogin","SUCCESS");
		}else {//로그인 실패
			mav.addObject("cartLogin","FAIL");
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/addcart.html")
	public ModelAndView addCart(String CODE,HttpSession session) {
		System.out.println("addCart ok");
		String id=(String)session.getAttribute("loginUser");
		if(id==null) { // 로그인 안한 경우
			ModelAndView mav=new ModelAndView("redirect:/cart/login.html");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		Cart cart=(Cart)session.getAttribute("CART");
		if(cart==null) cart=this.cart; //자동 주입된 카트 객체 사용
		cart.addCart(CODE, 1 , id);
		session.setAttribute("CART", cart);//카트를 세션에 저장
		ModelAndView mav=new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM",1);
		return mav;
	}

	
	@RequestMapping(value="/cart/login.html")
	public ModelAndView login() {
		System.out.println("login ok");
		ModelAndView mav=new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nocart");
		mav.addObject(new User());
		return mav;
	}
}
