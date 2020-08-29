package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
@Repository
public class ReadDaoImpl implements ReadDao {
	@Autowired
	private SqlSession session;
	
	public List<Bbs> readBbs() {
		return session.selectList("mapper.myMapper.getBBS");
	}

	public Bbs getBbsDetail(Integer seqno) {
		return session.selectOne("mapper.myMapper.getBBSwithId", seqno);
	}

	public List<Bbs> read5Bbs(Integer p) {
		return session.selectList("mapper.myMapper.getBBSCodition", p);
	}

	public Integer getBbsCount() {
		return session.selectOne("mapper.myMapper.getBBSCount");
	}

}
















