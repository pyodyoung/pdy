package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;
import model.User;

@Controller
public class ItemController {
	@Autowired
	ItemDao itemDao;
	
	@RequestMapping(value="item/itemDetail.html")
	public ModelAndView detail(String CODE) {
		ModelAndView mav=new ModelAndView("home/template");
		Item item=itemDao.getItemDetail(CODE); // jsp에서 보낸 Code
		mav.addObject("ITEM",item);
		mav.addObject("BODY","itemDetail.jsp");
		return mav;
	}
	@RequestMapping(value="/item/inputItem.html")
	public ModelAndView inputItem() {
		
		ModelAndView mav=new ModelAndView("home/template");
		mav.addObject("BODY","inputItem.jsp");
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping(value="/item/entry.html")
	public ModelAndView entry(@Valid Item item, BindingResult bindingResult, HttpSession session) {
		ModelAndView mav=new ModelAndView("home/template");
		if(bindingResult.hasErrors()) {
			mav.addObject("BODY","inputItem.jsp");
			return mav;
		}
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {//로그인을 안 한 경우
			mav.addObject("RESULT","nomember");
			//nologin.jsp에 객체(User)주입
			mav.addObject(new User());
			mav.addObject("BODY","nologin.jsp");//nologin.jsp를 출력
			return mav;
		}else {//로그인을 한 경우
			item.setItem_id(id);
			//DAO를 이용하여 삽입
			itemDao.putItem(item);
			return new ModelAndView("redirect:/item/itemList.html");
		}
	}
	@RequestMapping(value="/item/itemList.html")
	public ModelAndView itemList(Integer PAGENO) {
		ModelAndView mav=new ModelAndView("home/template");
		if(PAGENO ==null) PAGENO=1;
		//DB에서 상품정보 5개만 검색
		List<Item> itemList=itemDao.get5Items(PAGENO);
		//검색결과를 Mav에 저장
		mav.addObject("ITEM_LIST",itemList);
		//상품목록 jsp보내기
		mav.addObject("BODY","itemListView.jsp");
		//총 상품의 개수를 DB에서 찾는다
		//select count(*) from selling_item
		Integer totalItems=itemDao.getItemsCount();
		//상품의 갯수를 이용해서 총 페이지수를 찾는다.
		Integer pageCount= totalItems /5 ;
		// 총 페이지 수 = 총 상품의 갯수 / 5
		if(totalItems % 5 > 0 ) pageCount++;
		// if( (총 상품의 갯수 % 5 ) > 0 ) 총 페이지 수 = 총 페이지수 +1
		mav.addObject("PAGE_CNT",pageCount);
		//Mav에 총 페이지 수를 저장
		return mav;
	}
}
