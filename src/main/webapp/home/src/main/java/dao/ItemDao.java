package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	void putItem(Item item);
	List<Item> get5Items(Integer page); // 상품정보 5개 검색
	Item getItemDetail(String code); // 상품 디테일 번호로 찾기
	Integer getItemsCount(); //총 상품의 갯수 검사
}
