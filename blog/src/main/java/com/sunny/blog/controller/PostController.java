package com.sunny.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.blog.controller.dto.CommonRespDto;
import com.sunny.blog.model.Post;
import com.sunny.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final로 걸려있는 것들에 대해 constructor가 만들어짐
public class PostController {

	private final PostService postService;
	
	
//	@Autowired
//	private PostService postService;

	
//	public PostController(PostService postService) { // 생성자
//		this.postService = postService;
//	}
	
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "글쓰기 성공"); //post가 담겨야함
	}
	// 원래는 인증 필요없지만 post관련된 것은 인증 다 필요하게 연습!
	@GetMapping("/posts")
	public String getPosts(Model model){ // requestDispatcher
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
}

