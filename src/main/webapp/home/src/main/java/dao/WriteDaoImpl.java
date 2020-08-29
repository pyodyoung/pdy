package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
@Repository // Service는 바로 콘트롤러에 접근할 때 쓰지 않음. 지금은 바로 콘트롤러로 접근하기에 Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	public Integer getMaxId() {
		// TODO Auto-generated method stub
		return session.selectOne("mapper.myMapper.getSeqno");
	}

	public void insertBBS(Bbs bbs) {
		Integer seqno=this.getMaxId();
		if(seqno==null) seqno=0;
		seqno=seqno+1;
		Calendar today=Calendar.getInstance();
		int year=today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date=today.get(Calendar.DATE);
		String bbsDate=year+"/"+month+"/"+date;
		bbs.setSeqno(seqno);
		bbs.setRegister_date(bbsDate); // 작성일 설정
		session.insert("mapper.myMapper.insertBBS",bbs);
	}
}
