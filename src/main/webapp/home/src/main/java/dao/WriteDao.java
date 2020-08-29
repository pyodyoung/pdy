package dao;

import model.Bbs;

public interface WriteDao {
	Integer getMaxId();
	public void insertBBS(Bbs bbs);
}
