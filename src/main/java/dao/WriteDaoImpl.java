package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.ImageWriting;
@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	public Integer getMaxId() {
		return session.selectOne("mapper.myMapper.getSeqno");
	}
	public void insertBBS(Bbs bbs) {
		Integer seqno = this.getMaxId();
		if(seqno == null) seqno = 0;
		seqno = seqno + 1;
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
		bbs.setSeqno(seqno);//글번호 설정
		bbs.setRegister_date(bbsDate);//작성일 설정
		session.insert("mapper.myMapper.insertBBS", bbs);//DB에 삽입
	}
	
	//이미지 게시글 관련 ------------------------------------------------------
	public Integer getImageMaxId() {
		return session.selectOne("");
	}
	public void insertImage(ImageWriting w) {
		
	}
	public Integer getImageMaxGrId() {
		return session.selectOne("");
	}

}
























