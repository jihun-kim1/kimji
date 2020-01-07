package kh.picsell.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.picsell.dao.img_upDAO;
import kh.picsell.dto.img_upDTO;

@Service
public class Img_upService {
	@Autowired
	private HttpSession session;

	@Autowired
	private img_upDAO dao;
	
	public List<img_upDTO> getNoList() throws Exception{ //승인안된페이지
		return dao.getNoList();
	}
	public int accept(int img_seq) throws Exception{ //승인
		return dao.accept(img_seq);
	}
	public int delete(int img_seq) throws Exception{ //삭제
		return dao.delete(img_seq);
	}
}
