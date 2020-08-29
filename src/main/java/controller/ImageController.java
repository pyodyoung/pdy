package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.ImageWriting;

@Controller
public class ImageController {

	@RequestMapping(value="/image/writeForm.html")
	public ModelAndView form(HttpSession session) {
		ModelAndView mav = new ModelAndView("home/template");
		String id = (String)session.getAttribute("loginUser");
		if(id == null) {
			mav.addObject("BODY","writeFormLogin.jsp");
		}else {
			mav.addObject("BODY","writeForm.jsp");
			mav.addObject(new ImageWriting());//객체 주입
		}
		return mav;
	}
	@RequestMapping(value="/image/writen.html")
	public ModelAndView imagePost(@Valid ImageWriting imageWriting, 
			BindingResult bindingResult, HttpServletRequest request, HttpSession session,
			Integer order_no, Integer group_id, Integer parent_id) {
		ModelAndView mav=new ModelAndView("home/template");
		if(bindingResult.hasErrors()) {
			mav.addObject("BODY","writeForm.jsp");
			//mav.getModel().putAll(bindingResult.getModel()); 
			//view에 넣어주는 역할이었다. 근데 왜 필요 없는가?
			//Convention Over Configuration : 설정보단 관례
			//Only if u dont want to follow the convention,
			//you do configure own setting
			//스프링 프레임워크의 설계 철학 : 특별하게 지정하지 않으면, 기본을 적용한다.
			return mav;
		}
		MultipartFile multiFile=imageWriting.getImagename();
		String fileName=null; String path=null;
		OutputStream os=null;
		if(multiFile != null) {
			fileName=multiFile.getOriginalFilename(); //파일이름 설정
			ServletContext ctx=session.getServletContext();
			path=ctx.getRealPath("/upload/"+fileName);
			try {
				os = new FileOutputStream(path);//파일로 출력하는 객체 생성
				BufferedInputStream bis=new BufferedInputStream(multiFile.getInputStream());
				//업로드 파일로 부터 파일 입력 스트림 객체를 생성
				byte [] buffer=new byte[8156]; //8k크기
				int read=0; //읽은 바이트 수가 저장될 변수
				while((read = bis.read(buffer)) > 0) {
					//bis로 부터 읽음, 읽은 바이트 수가 존재하는 동안 반복
					os.write(buffer,0,read);//읽은 내용을 os로 출력
				}//반복이 끝나면 파일이 생성되고 사용한 객체를 닫습니다
				if(os !=null) os.close();
				if(bis !=null) bis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			imageWriting.setImage_name(fileName);
		}
		//이미지 게시글을 DB에 삽입
		//게시글 번호 최대 게시글 번호 자동증가
		return mav;
		
	}
}











