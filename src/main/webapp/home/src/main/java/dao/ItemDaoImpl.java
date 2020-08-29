package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	public void putItem(Item item) {
		session.insert("mapper.myMapper.putItem",item);
		
	}
	public List<Item> get5Items(Integer page) {
		return session.selectList("mapper.myMapper.getAllItemsCondition",page);
	}
	public Item getItemDetail(String code) {
		return session.selectOne("mapper.myMapper.getItemDetail",code);
	}
	public Integer getItemsCount() {
		return session.selectOne("mapper.myMapper.getItemsCount");
	}

}
