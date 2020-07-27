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
      }),
      $("#btn-delete").on("click", () => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
         this.deleteOne();
      }),
      $("#btn-update-mode").on("click", () => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
         this.updateMode();
      }),
      $("#btn-update").on("click", () => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
         this.update();
      })
     $("#btn-update").hide();
   },
   save: function(){ // 회원가입 로직 실행
      let data = {
         title:$("#title").val(),
         content:$("#content").val(),
         userId:$("#userId").val()
      };
      $.ajax({
         type:"POST",
         url:"/post", // post만 넣기
         data:JSON.stringify(data), // POST 방식이기 때문에 data를 날릴 수 있음
         contentType:"application/json; charset=utf-8", // 대소문자 구분
         dataType: "json"// 서버로부터 응답받을 때 데이터 타입
      }).done((resp)=>{ 
         alert("글쓰기 성공");
         location.href="/";
         console.log(resp); // 자바스크립트 오브젝트가 되서 날라옴
      }).fail((error)=>{ // 실패시 ajax 통신이 안된 것
         alert("글쓰기 실패");
         console.log(error);   
      })
   }, //save
   deleteOne: function(){ // 회원가입 로직 실행
      let data = {
         id:$("#id").val()
      };
      $.ajax({
         type:"DELETE",
         url:"/post/"+data.id, // post만 넣기
         dataType: "json"// 서버로부터 응답받을 때 데이터 타입
      }).done((resp)=>{ 
    	 if(resp.statusCode === 1){ // statusCode는 int값
    		 alert("삭제성공");
    		 location.href="/";
    	 }else{
    		 alert("권한없음:삭제실패");
    	 }
         console.log(resp); // 자바스크립트 오브젝트가 되서 날라옴
      }).fail((error)=>{ // 실패시 ajax 통신이 안된 것
         console.log(error);   
      });
   },// deleteOne
      
   updateMode: function(){
      $('#btn-update-mode').hide();
      $('#btn-update').show();
      
      $("#title").attr("readOnly",false);
      $("#content").attr("readOnly",false);
   },
   
   update: function(){ // 회원가입 로직 실행
      let data = {
         id:$("#id").val(),
         title:$("#title").val(),
         content:$("#content").val()
      };
      
      $.ajax({
         type:"PUT",
         url:"/post/"+data.id, // post만 넣기
         data:JSON.stringify(data),
         contentType:"application/json; charset=utf-8",
         dataType: "json"// 서버로부터 응답받을 때 데이터 타입
      }).done((resp)=>{ 
         alert("수정성공");
         location.href="/post/"+data.id;
         console.log(resp); // 자바스크립트 오브젝트가 되서 날라옴
      }).fail((error)=>{ // 실패시 ajax 통신이 안된 것
         alert("수정실패");
         console.log(error);   
      }); // deleteOne
   
   }

}

index.init();