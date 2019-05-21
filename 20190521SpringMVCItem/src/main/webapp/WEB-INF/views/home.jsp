<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 반복문이나 조건문을 사용해야 할 때 사용할 JSTL 태그 라이브러리 호출 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="stylesheet" href="css/style.css" >

</head>
<body>
	<div align="center" class="body" border="1">
		<h3>상품 목록 화면</h3>
		<table border="1">
			<tr class="header">
				<th width="80">상품ID</th>
				<th width="300">제품명</th>
				<th width="100">가격</th>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr class="record">
					<td align="center">${item.itemid}</td>
					<td>&nbsp;&nbsp;
						<a href="detail/${item.itemid}">
							${item.itemname}
						</a>
					</td>
					<td align="right">${item.price}원&nbsp;&nbsp;</td>
				
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>