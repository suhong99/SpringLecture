package ssg.com.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssg.com.a.dto.StudentDto;

@Controller		// <- annotation
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController hello() " + new Date());
		
		return "hello";		// hello.jsp 로 가라!
	}
	
	@RequestMapping(value="home.do", method=RequestMethod.GET)
	public String home(Model model) {
		System.out.println("HelloController home() " + new Date());
		String name="홍길동";
		//짐싸!
		model.addAttribute("name",name);
		
		//잘가
		return "home";  // 아무것도 안 적으면 GET
		
	}
	
	@RequestMapping(value="world.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String world(String name, int age) {
		System.out.println("HelloController world() " + new Date());
		
		System.out.println("name : " + name + "age : " +age);
		return "home";
	}
	
// 	@RequestMapping(value="object.do", method= RequestMethod.POS})
	@PostMapping("object.do")
	public String objectMethod(StudentDto dto) {
			System.out.println("HelloController Student");
			System.out.println(dto.toString());
			return "home";
			
	}
	
	@GetMapping("list.do")
	public String listMethod(String message, Model model) {
			System.out.println("HelloController listMethod()");
			System.out.println("message : " + message);
			
			List<StudentDto> list = new ArrayList<StudentDto>();
			list.add(new StudentDto("홍길동",24));
			list.add(new StudentDto("성춘향",44));
			list.add(new StudentDto("임슬옹",21));

			model.addAttribute("list",list);
			return "home";
	}
}
