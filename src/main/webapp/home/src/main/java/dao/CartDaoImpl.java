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
		// TODO Auto-generated method stub
		session.insert("mapper.cartMapper.putCart",cartItem);
	}

	public void deleteCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		session.delete("mapper.cartMapper.deleteCart",cartItem);
	}

	public void updateCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		session.update("mapper.cartMapper.updateCart",cartItem);
	}

	public Integer selectMaxCart() {
		// TODO Auto-generated method stub
		return session.selectOne("mapper.cartMapper.getSeqno"); 
	}

	public List<CartItem> selectCart(String id) {
		// TODO Auto-generated method stub
		return session.selectList("mapper.cartMapper.getCart",id);
	}

}
