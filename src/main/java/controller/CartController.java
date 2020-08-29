package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.CartDao;
import dao.LoginDao;
import model.Cart;
import model.CartItem;
import model.User;

@Controller
public class CartController {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private Cart cart;
	@Autowired
	private CartDao cartDao;
	
	@RequestMapping(value="/cart/modify.html")
	public ModelAndView modify(String CODE, Integer NUMBER, 
			String BTN, HttpSession session) {
		String id = (String)session.getAttribute("loginUser");
		if(BTN.equals("수정")) {
			cart.modifyItem(CODE, NUMBER);
			cart.setId(id);
		}else if(BTN.equals("삭제")) {
			cart.deleteItem(CODE);
			cart.setId(id);
		}
		return new ModelAndView("redirect:/cart/show.html");
	}
	
	@RequestMapping(value="/cart/show.html")
	public ModelAndView show(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		//로그인 여부를 검사한다.
		String id=(String)session.getAttribute("loginUser");
		if(id == null)//로그인을 안한경우 
			return mav;
		//로그인 계정으로 DB에서 장바구니 정보를 검색한다.
		List<CartItem> cartList = cartDao.selectCart(id);
		int totalAmount = 0;//가격의 총합을 위한 변수
		if(cartList.size() > 0) {//상품의 갯수가 존재하는 경우
			Iterator it = cartList.iterator();
			while(it.hasNext()) {
				CartItem ci = (CartItem)it.next();
				int total = ci.getPrice() * ci.getNum();//중간합계계산
				totalAmount = totalAmount + total;//총합계산
			}
			mav.addObject("totalAmount",totalAmount);
		}else {//상품의 갯수가 없는 경우,즉 상품이 없는 경우
			mav.addObject("totalAmount",0);
		}
		//장바구니 정보를 JSP(cartListView.jsp)로 전달한다.
		mav.addObject("BODY","cartListView.jsp");
		mav.addObject("CART_LIST", cartList);
		return mav;
	}
	
	@RequestMapping(value="/cart/addCart.html")
	public ModelAndView addCart(String CODE, HttpSession session) {
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {//로그인 안한 경우
			ModelAndView mav = new ModelAndView(
				"redirect:/cart/login.html");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null) cart = this.cart;//자동 주입된 카트 객체 사용
		cart.addCart(CODE, 1, id);//???
		session.setAttribute("CART", cart);//카트를 세션에 저장
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM",1);
		return mav;
	}

	@RequestMapping(value="/cart/login.html",method=RequestMethod.POST)
	public ModelAndView cartLogin(@Valid User user,
			BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("home/cartLogin");
			return mav;
		}
		ModelAndView mav = new ModelAndView("home/loginResult");
		//DB에서 로그인 시도
		User loginUser = loginDao.findByIdAndPwd(user);

		if(loginUser != null) {//로그인 성공
			session.setAttribute("loginUser", user.getId());//세션에 저장
			mav.addObject("cartLogin","SUCCESS");
		}else {//로그인 실패
			mav.addObject("cartLogin","FAIL");
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/login.html",method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("home/cartLogin");
		mav.addObject("RESULT","nocart");
		mav.addObject(new User());
		return mav;
	}
}



















