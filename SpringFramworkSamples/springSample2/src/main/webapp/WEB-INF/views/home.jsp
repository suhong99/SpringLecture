<%@page import="ssg.com.a.dto.StudentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>home</h2>
<%
	String name = (String)request.getAttribute("name");
%>
name : <%= name %>

<br><br>

<form action="world.do" method="post">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
<input type="submit" value="wolrd move">
</form>

<br><br>
<a href="world.do?name=성춘향&age=18">춘향전</a>

<br><br>
<form action="object.do" method="post">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
<input type="submit" value="wolrd move">
</form>

<!--
	<a message ="안녕하세요" 로 링크로 넘김/a>
		list.do에
		-> list를 테이블로 출력
	 -->

	 
<br><br>
<a href="list.do?message=안녕하세요">길동아</a>
	 
<br>
<%
	List<StudentDto> list = (List<StudentDto>) request.getAttribute("list");
	if(list != null && list.isEmpty()!=true){
	%>
	<table border="1">
		<tr>
			<th>번호</th>이름<th></th><th>나이</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
				StudentDto stu= list.get(i);
				%>
				<tr>
					<th><%= i+1 %></th>
					<td><%=stu.getName() %></td>
					<td><%=stu.getAge() %></td>
				</tr>
				<%
			}
		%>
	</table>
	
	<%
	
}
%>	 

</body>
</html>