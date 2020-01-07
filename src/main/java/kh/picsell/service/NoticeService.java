package kh.picsell.service;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import kh.picsell.dao.NoticeDAO;
import kh.picsell.dao.NoticeFileDAO;
import kh.picsell.dto.NoticeDTO;
import kh.picsell.dto.NoticeFileDTO;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO dao;
	
	@Autowired
	private NoticeFileDAO fileDao;
	
	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> noticeList = dao.selectAll();
		return noticeList;
	}
	
	@Transactional("txManager")
	public Map detail(int notice_seq) {
		dao.viewCountUp(notice_seq);
		NoticeDTO notice = dao.detail(notice_seq);
		NoticeDTO beforeNotice = dao.detail(notice_seq-1);
		NoticeDTO afterNotice = dao.detail(notice_seq+1);
		List<NoticeFileDTO> fileDto = fileDao.selectAll(notice_seq);
		
		Map map = new HashMap();
		map.put("notice", notice);
		map.put("beforeNotice", beforeNotice);
		map.put("afterNotice", afterNotice);
		map.put("fileDto", fileDto);
		return map;
	}
	
	public void write(NoticeDTO noticeDto, NoticeFileDTO fileDto, String file_path, String summernote_filePath) {
		
		File summernote_path = new File(summernote_filePath);  
		
		if(!summernote_path.exists()) {
			summernote_path.mkdir();
		} 
		
		Pattern p = Pattern.compile("<img.+?src=\"(.+?)\".+?data-filename=\"(.+?)\".*?>");
		Matcher m = p.matcher(noticeDto.getNotice_contents());
	
		try {
			while(m.find()) {
				String oriName = m.group(2);
				String sysName = System.currentTimeMillis() + "_" + oriName;
				String imageString = m.group(1).split(",")[1];
				
				byte[] imgBytes = Base64Utils.decodeFromString(imageString);
				FileOutputStream fis = new FileOutputStream(summernote_path + "/" + sysName);
				DataOutputStream dos = new DataOutputStream(fis);
				dos.write(imgBytes);
				dos.flush();
				dos.close();
				noticeDto.setNotice_contents(noticeDto.getNotice_contents().replaceFirst(Pattern.quote(m.group(1)), "/notice_summernote_files/" + sysName));				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		dao.write(noticeDto);
		int noticeFile_parentSeq = dao.getParentSeq(noticeDto.getNotice_writer());
		
		File filePath = new File(file_path);
		
		if(!filePath.exists()) {
			filePath.mkdir();
		}
		
		for(MultipartFile tmp : fileDto.getNoticeFile_file()) {
			if(!tmp.isEmpty()) {
				String noticeFile_oriName = tmp.getOriginalFilename();
				String noticeFile_sysName = System.currentTimeMillis() + "_" + noticeFile_oriName;
				
				fileDto.setNoticeFile_parentSeq(noticeFile_parentSeq);
				fileDto.setNoticeFile_oriName(noticeFile_oriName);
				fileDto.setNoticeFile_sysName(noticeFile_sysName);
				try {
					tmp.transferTo(new File(file_path + "/" + noticeFile_sysName));
					fileDao.fileUpload(fileDto);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
