package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlSession session;
	public User findByIdAndPwd(User user) {
		User usr = session.selectOne("user.getUser",user);
		return usr;
	}
	public Integer getIdCount(String id) {
		return session.selectOne("user.getIdCnt", id);
	}
	public void entryUser(User user) {
		// TODO Auto-generated method stub
		
	}

}

















