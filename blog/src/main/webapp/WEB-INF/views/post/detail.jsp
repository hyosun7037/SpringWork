<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">        
  <table class="table table-dark table-striped">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>제목</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><input id="id" type="text" value="${postDetailRespDto.id}" readonly/></td>
        <td><input id="title" type="text" value="${postDetailRespDto.title}" readonly/></td>
        <td><input id="content" type="text" value="${postDetailRespDto.content}" /> </td>
        <td><input id="username" type="text" value="${postDetailRespDto.username}" readonly/></td>
      </tr>
    </tbody>
  </table>
  <button id="btn-update" class="btn btn-warning">수정하기</button>
  <button id="btn-update-mode" class="btn btn-warning">수정</button>
  <button id="btn-delete" class="btn btn-danger">삭제</button>
</div>

<script src="/js/post.js"></script>

</body>
</html>
	<%@ include file="../layout/footer.jsp" %>