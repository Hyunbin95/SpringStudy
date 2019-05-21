<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<div align="center" class="body">
		<h3>상품 상세 보긔</h3>
		<table border="1">
			<tr>
				<!-- item.pictureurl 이용해서 출력 -->
				<td><img src="../img/${item.pictureurl}"
				width="200" height="200" /></td>
				<td align="center">
					<table border="1">
						<tr height="50" class="header" >
							<td width="80">상품명</td>
							<td width="160">${item.itemname}</td>
						</tr>
						<tr height="50" class="header">
							<td width="80">가격</td>
							<td width="160">${item.price}원</td>
						</tr>
						<tr height="50" class="record">
							<td width="80">설명</td>
							<td width="160">${item.description}</td>
						</tr>
						<tr height="50" class="record">
							<td colspan="2" align="center">
								<a href="../">메인으로</a>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>