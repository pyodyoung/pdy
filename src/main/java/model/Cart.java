package model;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;
@Service
public class Cart {//
	@Autowired
	private CartDao cartDao;
	private LinkedList<String> codeList =
				new LinkedList<String>();//
	
	public void setCodeList(Integer row, String code) {
		codeList.add(row, code);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumList(Integer row, Integer num) {
		numList.add(row, num);
	}

	public LinkedList<String> getCodeList() {
		return codeList;
	}

	public String getId() {
		return id;
	}

	public LinkedList<Integer> getNumList() {
		return numList;
	}

	private String id;//
	private LinkedList<Integer> numList = 
				new LinkedList<Integer>();//
	public Cart() {}//기본생성자
	public Cart(String id) {this.id = id;}//
	public void deleteItem(String code) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				codeList.remove(i);//
				numList.remove(i);//
				CartItem item = new CartItem();
				item.setId(id);	item.setCode(code);
				cartDao.deleteCart(item);
				return; //
			}//
		}
	}
	public void modifyItem(String code, int num) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, num);//
				CartItem item = new CartItem();
				item.setId(id);	item.setCode(code);
				item.setNum(numList.get(i));
				cartDao.updateCart(item);;//
				return;//
			}//
		}
	}
	public void addCart(String code, int num, String id) {
		this.id = id;
		for(int i=0; i<codeList.size();i++) {//
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i)+num);//
				CartItem item = new CartItem();
				item.setCode(code);//
				item.setNum(numList.get(i));//
				item.setId(id);
				cartDao.updateCart(item);;//
				return;//
			}//
		}
		codeList.add(code); numList.add(num);
		CartItem item = new CartItem();
		Integer seqno = cartDao.selectMaxCart();
		if(seqno == null) seqno = 0;
		item.setSeqno(seqno+1); item.setCode(code);
		item.setNum(num);		item.setId(id);
		cartDao.insertCart(item);;//
		//
	}//
}

















