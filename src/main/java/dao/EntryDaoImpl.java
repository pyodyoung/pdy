package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;
@Repository
public class EntryDaoImpl implements EntryDao { //인터페이스느 공부하기  컨트롤러 다오에서 심부름 다오가 다오임플에게 심부름. 
	@Autowired
	private SqlSession session;
	public void entryUser(User user) {
		session.insert("mapper.myMapper.insertMember", user); //심부름 시킨 돈을 준 심부름 킨
	}
}
