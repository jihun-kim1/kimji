package kh.picsell.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/writer")
public class WriterController {

	// 공모전 페이지
		@RequestMapping("/writer.do")
		public String contest() {
			System.out.println("Writer Page");
			return "writer/writer";
		}
}
