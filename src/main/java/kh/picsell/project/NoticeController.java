package kh.picsell.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.picsell.dto.NoticeDTO;
import kh.picsell.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService NoticeService;
	
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

}
