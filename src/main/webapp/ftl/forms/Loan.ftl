<html>
<head><title>Loan Form</title>
<body>
<div id="header">

</div>

<div id="content">
    
  <fieldset>
  	<legend>Add User</legend>
  <form name="user" action="add.html" method="post">
  	Firstname: <input type="text" name="firstname" />	<br/>
  	Lastname: <input type="text" name="lastname" />	<br/>
  	<input type="submit" value="   Save   " />
  </form>
  </fieldset>
  <br/>
  <table class="datatable">
  	<tr>
  		<th>Firstname</th>  <th>Lastname</th>
  	</tr>
    <#list model["customerDtoList"] as user>
  	<tr>
  		<td>${user.customerId}</td> <td>${user.customerName}</td>
  	</tr>
    </#list>
  </table>

</div>  
</body>
</html>  