package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;
@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession session;
	public void insertCart(CartItem cartItem) {
		System.out.println("계정:"+cartItem.getId());
		System.out.println("상품번호:"+cartItem.getCode());
		System.out.println("갯수:"+cartItem.getNum());
		session.insert("mapper.cartMapper.putCart",cartItem);
	}
	public void deleteCart(CartItem cartItem) {
		session.delete("mapper.cartMapper.deleteCart",cartItem);
	}
	public void updateCart(CartItem cartItem) {
		session.update("mapper.cartMapper.updateCart",cartItem);
	}
	public Integer selectMaxCart() {
		return session.selectOne("mapper.cartMapper.getSeqno");
	}
	public List<CartItem> selectCart(String id) {
		return session.selectList("mapper.cartMapper.getCart", id);
	}

}







