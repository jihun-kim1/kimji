package kh.picsell.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contest")
public class ContestController {

	// 공모전 페이지
	@RequestMapping("/contest.do")
	public String contest() {
		System.out.println("Contest Page");
		return "contest/contest";
	}
	
	// 새로운 공모전 열기
	@RequestMapping("/newOpen.do")
	public String newOpen() {
		System.out.println("New Contest Open Page");
		return "contest/newOpen";
	}
}
