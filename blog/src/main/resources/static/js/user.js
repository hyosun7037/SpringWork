let index = {
	init: function(){ // 이벤트 리스너 바인딩
		//회원가입 리스너
		$("#btn-save").on("click", () => { 
			// 콜백이 되는 스택, 클릭될때까지 지켜보다가 클릭되면 콜백하는 쪽으로 날림
			this.save();
		}), // 수정 추가할꺼면 그대로 복사해서 변수명만 바꿔줌
		//로그인 리스너
		$("#btn-login").on("click", () => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
			this.login();
		}); 
	},
	save: function(){ // 회원가입 로직 실행
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		$.ajax({
			type:"POST",
			url:"/auth/joinProc", // 권한과 인증이 필요없는 경우 auth
			data:JSON.stringify(data), // POST 방식이기 때문에 data를 날릴 수 있음
			contentType:"application/json; charset=utf-8", // 대소문자 구분
			dataType: "json"// 서버로부터 응답받을 때 데이터 타입
		}).done((resp)=>{
			alert("회원가입 성공");
			location.href="/";
			console.log(resp); // 자바스크립트 오브젝트가 되서 날라옴
		}).fail((error)=>{ // 실패시 ajax 통신이 안된 것
			alert("회원가입 실패");
			console.log(error);	
		})
	}, //save
	
	login: function(){ // 회원가입 로직 실행
		let data = {
			username:$("#username").val(),
			password:$("#password").val()
		};
		$.ajax({
			type:"POST",
			url:"/auth/loginProc", // 권한과 인증이 필요없는 경우 auth
			data:JSON.stringify(data), // POST 방식이기 때문에 data를 날릴 수 있음
			contentType:"application/json; charset=utf-8", // 대소문자 구분
			dataType: "json"// 서버로부터 응답받을 때 데이터 타입
		}).done((resp)=>{
			if(resp.statusCode == 1) {// 통신은 무조건 String, 하지만 int로 만들었으니까 1로 설정
				alert("로그인 성공");
				location.href="/";
				console.log(resp); 
			}else{
				alert("아이디와 패스워드를 다시 입력하세요");
				console.log(resp); 
			}
		}).fail((error)=>{ 
			alert("로그인 실패");
			console.log(error);	
		})
	} // login
}

index.init();