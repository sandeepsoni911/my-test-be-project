<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Loan Form</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<script>



function sendData() {
	
	
	//validateLoanAmount();
	//valItemType();
	//valDueDate();
	
		const form = document.getElementById("loanFormId");

	// Get the form data with our (yet to be defined) function.
	const data = getFormData(form.elements);
	console.log(JSON.stringify(data));
    $.ajax({
        url: 'http://localhost:8080/CounterWebApp/loan',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function(d){ console.log(d); },
    });
}


	
//utility function
function getFormData(data) {
   var unindexed_array = data;
   var indexed_array = {};

   $.map(unindexed_array, function(n, i) {
    indexed_array[n['name']] = n['value'];
   });
   console.log("json object : "+indexed_array);
   return indexed_array;
}


$(function() {
    $( "#dueDateDatepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
});


function validateLoanAmount(){
	var name = document.getElementById("loanAmount").value;
	if(name == null || name==""){
		$("#loanAmountErrorId").show();
		$('#loanAmountErrorId').html("Please enter valid loan amount.");
		
	}else{
		$("#loanAmountErrorId").hide();
	}
}

function valItemType(){
	var name = document.getElementById("itemType").value;
	if(name == null || name==""){
		$("#itemTypeErrorId").show();
		$('#itemTypeErrorId').html("Please enter a item Type.");
	}else{
		$("#itemTypeErrorId").css("display", "none");
	}
}

function valDueDate(){
	var dueVal = document.getElementById("dueDateDatepicker").value;
	if(dueVal == null || dueVal==""){
		$("#dueDateErrorId").show();
		$('#dueDateErrorId').html("Please enter valid due date.");
	}else{
		$("#dueDateErrorId").css("display", "none");
	}
}

function isValidDate(date)
{
    var matches = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/.exec(date);
    if (matches == null) return false;
    var d = matches[2];
    var m = matches[1] - 1;
    var y = matches[3];
    var composedDate = new Date(y, m, d);
    return composedDate.getDate() == d &&
            composedDate.getMonth() == m &&
            composedDate.getFullYear() == y;
}

function rateOfInterest(){
	var name = document.getElementById("rate").value;
	if(name == null || name==""){
		$("#RateOfInterestErrorId").show();
		$('#RateOfInterestErrorId').html("Please enter rate of interest.");
	}else{
		$("#RateOfInterestErrorId").css("display", "none");
	}
}

function itemNameValidate(){
	var itemNameVal = document.getElementById("itemNameId").value;
	if(itemNameVal == null || itemNameVal==""){
		$("#itemNameErrorId").show();
		$('#itemNameErrorId').html("Please enter name of item.");
	}else{
		$("#itemNameErrorId").css("display", "none");
	}
}

function cuurentMarketRateValidate(){
	
	var itemNameVal = document.getElementById("cuurentMarketRateId").value;
	if(itemNameVal == null || itemNameVal==""){
		$("#cuurentMarketRateErrorId").show();
		$('#cuurentMarketRateErrorId').html("Please enter Today's market rate.");
	}else{
		$("#cuurentMarketRateErrorId").css("display", "none");
	}
	
}

function weightIdValidate(){
	var itemNameVal = document.getElementById("weightId").value;
	if(itemNameVal == null || itemNameVal==""){
		$("#weightErrorId").show();
		$('#weightErrorId').html("Please enter weight of item.");
	}else{
		$("#weightErrorId").css("display", "none");
	}
}



</script>



</head>
<body>
<h1>Loan Form</h1>


<div>


<form   name="loanForm" id="loanFormId" class="animate form">
			<table style="with: 100%">
				<tr>
					<td>Customer Name* </td>
					<td>
					<select name="customerId">
  						<c:forEach items="${customerDtoList}" var="customerDto">
   							 <option value="${customerDto.customerId}">
       										 ${customerDto.customerName}
    						</option>
  						</c:forEach>
</select></td>
				</tr>
				
				<tr>
					<td>Loan Amount* </td>
					<td><input type="text" name="loanAmount" id ="loanAmount" onblur="validateLoanAmount()" />
					</td> <td id="loanAmountErrorId" style=color:red align=left></td>

				<tr>
					<td>Item Type*</td>
					<td>   <select name="itemType" id="itemType" >
					<option value="GOLD">Gold</option>
					<option value="SILVER">Silver</option>
					<option value="PLATINUM">Platinum</option>
					</select>         
					</td> <td id="itemTypeErrorId" style=color:red align=left></td>
				</tr>
				<tr>
					<td>Loan Due Date*</td>
					<td><input type="text" id="dueDateDatepicker" name = "dueDate"  onblur="valDueDate()" /></td>
					 <td id="dueDateErrorId" style=color:red align=left></td>
				</tr>
				<tr>
					<td>Rate of Interest*</td>
					<td><input type="text" name="rateOfInterest" id="rate"  onblur="rateOfInterest()" /></td>
					 <td id="RateOfInterestErrorId" style=color:red align=left></td>
				</tr>
				
				<tr>
					<td>Item Name*</td>
					<td><input type="text" name="itemName" id="itemNameId"  onblur="itemNameValidate()" /></td>
					 <td id="itemNameErrorId" style=color:red align=left></td>
				</tr>
				<tr>
					<td>Market Rate(per 10g)*</td>
					<td><input type="text" name="cuurentMarketRate" id="cuurentMarketRateId" onblur="cuurentMarketRateValidate()"  /></td>
					 <td id="cuurentMarketRateErrorId" style=color:red align=left></td>
				</tr>
				<tr>
					<td>Weight of Item (in gram)*</td>
					<td><input type="text" name="weight" id="weightId"  onblur="weightIdValidate()" /></td>
					 <td id="weightErrorId" style=color:red align=left></td>
				</tr>
				
				<tr>
					<td>Comments</td>
					<td><input type="text" name="comment" id="commentId"  /></td>
					 <td id="commentErrorId" style=color:red align=left></td>
				</tr>
				
				</table>
				<input type="hidden" id="statusId" name="status" value="OPEN">
			<input type="submit" value="Submit" onclick="sendData()" />
			
			</form>
			
	</div>
</body>
</html>