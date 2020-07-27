<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
   div {
      width: 700px;
      margin: auto;
      text-align: center;
      box-sizing: border-box;
   }
   div table {
      width: 700px;
      border-collapse: collapse;
   }
   div table th, td {
      border: 1px solid #5F04B4;
      padding: 10pt;
   }
   thead {
      background-color: #5F04B4;
      color:white;   
      font-size:20px;
   }
   input[type=button],input[type=reset] {
      background-color: #5F04B4;
      color:white;      
   }
</style>
<script type="text/javascript">
   function view_one( f ) {
      if ( f.id.value == "" ) {
         alert("검색 할 회원의 아이디를 먼저 입력하세요.");
         f.id.focus();
         return;
      }
      f.action = "view_one.jsp";
      f.submit();
   }
   function insert( f ) {
      if ( f.id.value == "" ) {
         alert("추가 할 회원의 아이디를 먼저 입력하세요.");
         f.id.focus();
         return;
      }
      if ( f.pw.value == "" ) {
         alert("추가 할 회원의 비밀번호를 먼저 입력하세요.");
         f.pw.focus();
         return;
      }
      if ( f.name.value == "" ) {
         alert("추가 할 회원의 성명을 먼저 입력하세요.");
         f.name.focus();
         return;
      }
      if ( f.age.value == "" ) {
         alert("추가 할 회원의 나이를 먼저 입력하세요.");
         f.age.focus();
         return;
      }
      if ( f.addr.value == "" ) {
         alert("추가 할 회원의 주소를 먼저 입력하세요.");
         f.addr.focus();
         return;
      }
      f.action = "insert.jsp";
      f.submit();
   }
   function remove( f ) {
      if ( f.id.value == "" ) {
         alert("삭제 할 회원의 아이디를 먼저 입력하세요.");
         f.id.focus();
         return;
      }
      if ( f.pw.value == "" ) {
         alert("삭제 할 회원의 비밀번호를 먼저 입력하세요.");
         f.pw.focus();
         return;
      }
      f.action = "remove.jsp";
      f.submit();
   }
   
   function update( f ) {
      if ( f.id.value == "" ) {
         alert("수정 할 회원의 아이디를 먼저 입력하세요.");
         f.id.focus();
         return;
      }
      if ( f.pw.value == "" ) {
         alert("수정 할 회원의 비밀번호를 먼저 입력하세요.");
         f.pw.focus();
         return;
      }
      f.action = "update.jsp";
      f.submit();
   }
</script>

</head>
<body>
	<div>
		<form method="post">
			<table>
				<thead>
					<tr>
						<th colspan="2">녹색 회원 관리</th>
					</tr>
				</thead>
			
				<tbody>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" autofocus></td>
					</tr>
					<tr>					
						<td>비밀번호</td>
						<td><input type="password" name="pw" autofocus></td>
					</tr>
					<tr>					
						<td>성명</td>
						<td><input type="text" name="name" autofocus></td>
					</tr>
					<tr>					
						<td>나이</td>
						<td><input type="text" name="age" autofocus></td>
					</tr>
					<tr>					
						<td>주소</td>
						<td><input type="text" name="addr" autofocus></td>
					</tr>
				</tbody>
					
				<tfoot>
					<tr>
						<th colspan="2">
							<input type="button" value="전체검색" onclick="location.href='view_all.jsp'">&nbsp;&nbsp;&nbsp;
							<input type="button" value="회원검색" onclick="view_one(this.form)">&nbsp;&nbsp;
							<input type="button" value="회원추가" onclick="insert(this.form)">&nbsp;&nbsp;
							<input type="button" value="회원삭제" onclick="remove(this.form)">&nbsp;&nbsp;
							<input type="button" value="회원수정" onclick="update(this.form)">&nbsp;&nbsp;
					</tr>
				</tfoot>
			
			</table>
		</form>
	
	</div>
</body>
</html>