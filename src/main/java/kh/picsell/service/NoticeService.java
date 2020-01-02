package kh.picsell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.picsell.dao.NoticeDAO;
import kh.picsell.dto.NoticeDTO;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO dao;
	
	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> noticeList = dao.selectAll();
		return noticeList;
	}
}
