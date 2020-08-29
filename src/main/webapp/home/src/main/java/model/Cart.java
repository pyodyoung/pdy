package model;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;

//import crud.CartCrud;
@Service // Dao를 사용하는 클래스는 Service
public class Cart { // 장바구니 객체
	@Autowired
	private CartDao cartDao;

	public Cart() {}//기본생성자
	private LinkedList<String> codeList= new LinkedList<String>(); // 똑같은 객체가 들어간다 
	private String id;
	private LinkedList<Integer> numList= new LinkedList<Integer>();
	public Cart(String id) {this.id=id;	}
	public LinkedList<String> getCodeList() {return codeList;}
	public String getId() {return id;}
	public LinkedList<Integer> getNumList() {return numList;}
	public void modifyItem(String code, int num) {
		//장바구니에서 상품의 갯수를 변경하는 메서드
		//codeList에 있는 모든 상품의 번호와 code를 비교해서,
		//같으면 현재 갯수를 num으로 바꾼다.
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, num);//i번째 상품갯수를 num으로 변경
				CartItem item=new CartItem();
				item.setId(id);
				item.setNum(numList.get(i));
				item.setCode(code);
				cartDao.updateCart(item);
				return;//메서드 종료
			}//codeList의 i번째 상품번호와 code가 같은 경우
		}
	}
	public void deleteItem(String code) {
		//장바구니에서 상품을 삭제하는 메서드
		//codeList에 있는 모든 상품의 번호와 입력된 번호(code)가 일치하면
		//codeList와 numList에서 해당상품 정보를 삭제한다.
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				codeList.remove(i);//i번째 상품번호 삭제
				numList.remove(i);//i번째 상품갯수 삭제
				CartItem item=new CartItem();
				item.setId(id); item.setCode(code);
				cartDao.deleteCart(item);
				return; //메서드 종료
			}//codeList의 i번째 상품번호와 입력된 상품번호가 같은경우
		}
	}
	public void addCart(String code, int num, String id) {
		//code와 개수를 추가합니다. 각각 List에 저장해야겠죠.
		//하지만 리스트를 활용하면 같은 값도 계속 넣어지기 때문에 개수 확인에 문제가 생길 수 있습니다.
		// a100, a100, b100, b100, c100
		// 1,    1,	 	1,	   1,	 1     <= 이건 개수확인이 힘들죠
		// 따라서 같은 코드가 있는 경우 개수만 추가하는 로직을 구현해야합니다.
		this.id=id;
		for(int i=0;i<codeList.size();i++) {//codeList의 길이만큼 반복하며 중복아이템을 찾는다.
			if(codeList.get(i).equals(code)) { // 같은 코드인  상품이 있는 경우
				numList.set(i, numList.get(i)+num); // i의 인덱스넘버를 가진 상품코드의 갯수가 증가
				return; //메서드 종료
			}
		}
		codeList.add(code); numList.add(num); // 저장한다
		CartItem item=new CartItem();
		Integer seqno=cartDao.selectMaxCart();
		if(seqno==null) seqno=0;
		item.setSeqno(seqno+1); item.setCode(code);
		item.setNum(num); item.setId(id);
		cartDao.insertCart(item);
	}
}
