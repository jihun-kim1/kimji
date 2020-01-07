package kh.picsell.project;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.picsell.dto.NoticeDTO;
import kh.picsell.dto.NoticeFileDTO;
import kh.picsell.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService NoticeService;

	@Autowired
	private HttpSession session;

	ModelAndView mav = new ModelAndView();

	@RequestMapping("/notice.do")
	public ModelAndView notice() {
		try {
			List<NoticeDTO> noticeList = NoticeService.noticeList();
			mav.addObject("noticeList", noticeList);
			mav.setViewName("notice/notice");
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping("/detail.do")
	public ModelAndView detail(int notice_seq) {

		System.out.println(notice_seq);
		try {
			Map map = NoticeService.detail(notice_seq);
			System.out.println(map.get("fileDto").toString());
			mav.addObject("map", map);
			mav.setViewName("notice/noticeView");
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping("/noticeWrite.do")
	public ModelAndView write() {
		try {
			mav.setViewName("notice/noticeWrite");
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping("/writeProc.do")
	public String writeProc(NoticeDTO noticeDto, NoticeFileDTO noticeFileDto) {
		String nickName = "a123";
		noticeDto.setNotice_writer(nickName);
		String file_path = session.getServletContext().getRealPath("/notice_files");
		System.out.println(file_path);
		String summernote_filePath = session.getServletContext().getRealPath("notice_summernote_files") ;

		try {
			NoticeService.write(noticeDto, noticeFileDto, file_path, summernote_filePath);
			return "redirect:/notice/notice.do";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/fileDownLoad.do")
	public void fileDownLoad(String oriName, String sysName, HttpServletResponse response) {
		String path = session.getServletContext().getRealPath("/notice_files");
		System.out.println(path);
		String fullPath = path + "/" + sysName;
		File file = new File(fullPath);

		try(
				FileInputStream fis = new FileInputStream(file);
				DataInputStream fileDis = new DataInputStream(fis);
				ServletOutputStream sos = response.getOutputStream();
				){
			byte[] fileContents = new byte[(int)file.length()];
			fileDis.readFully(fileContents);

			response.setContentType("application/octet-stream");
			String encFileName = new String(oriName.getBytes("utf8"),"iso-8859-1");
			response.setHeader("Content-Disposition", "attatchment; filename=\""+encFileName+"\"");
			response.setHeader("Content-Length", String.valueOf(file.length()));

			sos.write(fileContents);
			sos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
