package dao;

import model.User;

public interface LoginDao {
	User findByIdAndPwd(User user);
	Integer getIdCount(String id);//입력한 계정의 갯수를 리턴
	public void entryUser(User user);
}
