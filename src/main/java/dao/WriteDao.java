package dao;

import model.Bbs;
import model.ImageWriting;

public interface WriteDao {
	Integer getMaxId();//최대 글번호 검색
	void insertBBS(Bbs bbs);//게시글 삽입
	
	//이미지게시글 관련
	Integer getImageMaxId();
	void insertImage(ImageWriting w);
	//최대 그룹번호 이미지글 검색
	Integer getImageMaxGrId(); //최대 그룹번호 이미지글 검색
}
