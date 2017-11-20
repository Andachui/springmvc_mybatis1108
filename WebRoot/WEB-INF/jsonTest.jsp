<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js" ></script>
<script type="text/javascript">
	function requestJson() {
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath }/requestJson.action',
			contentType:'application/json;charset=utf-8',
			data:'{"name":"手机","price":"999"}',
			success:function(data){
				alert(data);
			}
		});
	}
	
	function resPonseJson() {
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath }/responseJson.action',
			//contentType:'application/json;charset=utf-8',
			data:'name=手机&price=999',
			success:function(data){
				alert(data.name);
			}
		});
	}
</script>
</head>
<body>
	<input type="button" value="请求json返回json" onclick="requestJson()">
	<input type="button" value="请求json返回json" onclick="resPonseJson()" >
</body>
</html>