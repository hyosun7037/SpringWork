package com.sunny.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	Test t;
	
	@GetMapping("index")
		public String home() {
			return "index";
		}

	
	//http://localhost:8080/
	@GetMapping({"","/"})
	public @ResponseBody String index() {
		System.out.println(t.num);
		return "Hello"; //ViewResolver
	}
	
	//x-www-form-urlencoded => key=value 형태
	@PostMapping("/form")
	public @ResponseBody String form(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);
		return "User"; //ViewResolver
	}
	
	//x-www-form-urlencoded => key=value 형태
	@PostMapping("/form/model")
		public @ResponseBody String formModelPost(User user) {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println(user.getEmail());
			return "User"; //ViewResolver
	}
		
	//x-www-form-urlencoded => key=value 형태
			@GetMapping("/form/model")
			public @ResponseBody String formModelGet(User user) {
				System.out.println(user.getUsername());
				System.out.println(user.getPassword());
				System.out.println(user.getEmail());
				return "User"; //ViewResolver
	}

			
	//json => { "key" : 값 }
			@PostMapping("/json/model")
			public @ResponseBody User JsonModel(@RequestBody User user) {
				System.out.println(user.getUsername());
				System.out.println(user.getPassword());
				System.out.println(user.getEmail());
				return user; //ViewResolver
	}
}
