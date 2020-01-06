package kh.picsell.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("Index Page");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("Main Page");
		return "home";
	}
	
	@RequestMapping("/contest")
	public String contest() {
		System.out.println("Contest Page");
		return "contest/contest";
	}
	
	@RequestMapping("/writer")
	public String writer() {
		System.out.println("Writer Page");
		return "writer/writer";
	}

}