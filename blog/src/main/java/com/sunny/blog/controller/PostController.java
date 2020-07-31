package com.sunny.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.blog.config.handler.exception.MyRoleException;
import com.sunny.blog.controller.dto.CommonRespDto;
import com.sunny.blog.model.Post;
import com.sunny.blog.model.User;
import com.sunny.blog.repository.PostRepository;
import com.sunny.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //final로 걸려있는 것들에 대해 constructor가 만들어짐
public class PostController {

	private final PostService postService;
	private final PostRepository postRepository; // 인증체크
	
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
	
	// /post/안녕 => 오류
	// ?주소 => 쿼리스트링 받는 것
	// /post/{id} => 파라미터를 받는것
	@GetMapping("/post/{id}") //파라미터로 데이터를 받을 수 있음
	public String getPost(@PathVariable int id, Model model) { // int 값으로 주소 값을 받아줌
		model.addAttribute("postDetailRespDto",postService.상세보기(id));
		return "post/detail";
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteProc(@PathVariable int id, HttpSession session, MyRoleException myRoleException) throws MyRoleException {
		// 세션 값 확인
		User principal = (User)session.getAttribute("principal");
		Post postEntity =  postRepository.findOne(id);
		if(principal.getId() != postEntity.getUserId()) {
//			throw new MyRoleException();
			return new CommonRespDto<String>(-1, "권한없음");
		}
		postService.삭제하기(id);
		return new CommonRespDto<String>(1, "삭제 성공");
	}
	
	@PutMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> update(@RequestBody Post post) {
		postService.수정하기(post); //post 안에 있으니까 id는 따로 안받아도 됨
		return new CommonRespDto<String>(1, "수정 성공");
	}
	
	
}

