<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customer registration</title>

<script>

function validation(){
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var emailReg = /^([w-.]+@([w-]+.)+[w-]{2,4})?$/;
	if( name ==='' || email ===''){
	alert("Please fill all fields...!!!!!!");
	return false;
	}else if(!(email).match(emailReg)){
	alert("Invalid Email...!!!!!!");
	return false;
	}else{
	return true;
	}
	}
	
	
function formSubmit()
{
	
	var name = document.getElementById("customerNameId").value;
	var address = document.getElementById("customerAddress").value;
	var city = document.getElementById("customerCity").value;
	var phone = document.getElementById("customerPhoneId").value;
	
	
	
	var url = "http://localhost:8080/CounterWebApp/registerApi?custName="+name+"&custPhone="+phone+"&address="+address+"&city="+city; 
	document.customerForm.action=url;
//     $.ajax({
//            type: "POST",
//            url: url,
//            contentType: 'application/json',
//            data: $("#customerFormId").serialize(), // serializes the form's elements.
//            success: function(data)
//            {
//                alert(data); // show response from the php script.
//            }
//          });
     document.getElementById("customerFormId").submit();
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

function phonenumberValidation()
{
  var inputtxt =document.getElementById("customerPhoneId");
  var phoneno = /^\d{10}$/;
  if((inputtxt.value.match(phoneno))){
      return true;
        }else{
        alert("Please enter valid phone number");
        return false;
        }
}

function validateName(){
	var x = document.getElementById("customerNameId") ;
	if(/^[A-Za-z\s]+$/.test(x)){
		return true
	}else{
		alert("please enter valid name")
	}
}

</script>



</head>
<body>
<h1>Customer Registration Form</h1>
<form   method="GET" name="customerForm" id="customerFormId">
			<table style="with: 100%">
				<tr>
					<td>Name </td>
					<td><input type="text" name="custName"  id = "customerNameId" /></td>
				</tr>
				
				<tr>
					<td>Address*</td>
					<td><input type="text" name="address" id ="customerAddress" /></td>
<!-- 				</tr> -->
<!-- 					<tr> -->
<!-- 					<td>Password</td> -->
<!-- 					<td><input type="password" name="password" /></td> -->
<!-- 				</tr> -->
				<tr>
					<td>City*</td>
					<td><input type="text" name="city" id="customerCity" /></td>
				</tr>
				<tr>
					<td>Contact Number*</td>
					<td><input type="text" name="custPhone" id="customerPhoneId" /></td>
				</tr></table>
			<input type="submit" value="Submit" onclick="formSubmit()" /></form>
</body>
</html>