package kh.picsell.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.picsell.dto.img_upDTO;
import kh.picsell.service.Img_upService;

@Controller
@RequestMapping("/img_up")
public class Img_upController {
@Autowired
private HttpSession session;
@Autowired
private Img_upService service;
@Autowired
private HttpServletRequest request;
@RequestMapping("/NoList")
public String Nolist(img_upDTO dto) { //사진목록(승인안된것만)
	List<img_upDTO> list;
	try {
		list = service.getNoList();
		request.setAttribute("list", list);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "Img_up/noList";
}

@RequestMapping(value="/accept.do", produces="text/html; charset=UTF-8")
@ResponseBody
public String accept(int img_seq) { //사진심사 승인
	int result;
	try {
		result = service.accept(img_seq);
		if(result>0) {
			return "성공";
		}else {
			return "실패";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return "서버";
	}
}
@RequestMapping(value="/delete.do", produces="text/html; charset=UTF-8")
@ResponseBody
public String delete(int img_seq) { //사진삭제
	int result;
	try {
		result = service.delete(img_seq);
		if(result>0) {
			return"성공";
		}else {
			return "실패";
		}
	} catch (Exception e) {
		e.printStackTrace();
		return"서버";
	}
}
}
