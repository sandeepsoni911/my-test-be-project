<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Loan Details</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>


</script>



</head>
<body>
<h1>Loan Details</h1>

			<table style="with: 100%" border="1px">
				
				<tr>
					<th>Customer Name </th>
					<th>Loan Amount </th>
					<th>Item Type</th>
					<th>Loan Due Date</th>
					<th>Rate of Interest</th>
					<th>Item Name</th>
					<th>Market Rate(per 10g)</th>
					<th>Weight of Item (in gram)</th>
					<th>Loan Status</th>
					<th>Comments</th>
				</tr>
			<c:forEach items="${loanDetailList}" var="loanDto">
				<tr>
					<td><c:out value="${loanDto.customerId}" /></td>
					<td><c:out value="${loanDto.loanAmount}" /></td>
					<td><c:out value="${loanDto.itemType}" /></td>
					<td><c:out value="${loanDto.dueDate}" /></td>
					<td><c:out value="${loanDto.rateOfInterest}" /></td>
					<td><c:out value="${loanDto.itemName}" /></td>
					<td><c:out value="${loanDto.cuurentMarketRate}" /></td>
					<td><c:out value="${loanDto.weight}" /></td>
					<td><c:out value="${loanDto.status}" /></td>
					<td><c:out value="${loanDto.comments}" /></td>
				</tr>
			</c:forEach>
			<tr>
				
				</tr>
				</table>
</body>
</html>