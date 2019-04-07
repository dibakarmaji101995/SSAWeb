<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SSN ENTROLlMENT</title>
<style>
.error {
	color: #FF0000
}
</style>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
  
  <script>
  
  $( function() {
	  $('form[id="ssnGenerate"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				fatherName: 'required',
				motherName: 'required',
				dob : 'required',
				ssn : 'required',
				gender : 'required',
				state : 'required'
			},
			messages : {
				firstName : 'Please enter first name',
				lastName : 'please enter last name',
		        fatherNmae : 'please enter father name',
		        motherName : 'please enter mother name',	 
				dob : 'Please select dob',
				ssn : 'Please enter SSN',
				gender : 'Please select Gender',
				state : 'Please select a state'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	  
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormat:'dd-mm-yy',
      maxDate: new Date()
    });
    
  } );
  $(document).ready(function() {
		$.ajax({
			url : 'state',
			cache : false,
			dataType : 'json',
			success : function(result) {
				$.each(result, function(key, value) {
					$('<option>').val(key).text(value).appendTo("#state");
				});
			}
		});
	});
  </script>
</head>
<body>
  <h1 style="color:red;text-align:center">SSN ENTROLLMENT</h1>
  
  <font color="green">${success}</font>
  <font color="red">${failure}</font>
  
  <form:form action="ssnGen" method="POST" modelAttribute="personModel" id="ssnGenerate">
      <table border="1" align="center">
         <tr>
            <td>First Name</td>
            <td><form:input path="firstName"/></td>
         </tr>
         <tr>
            <td>Last Name</td>
            <td><form:input path="lastName"/></td>
         </tr>
         <tr>
            <td>Father Name</td>
            <td><form:input path="fatherName"/></td>
         </tr>
         <tr>
            <td>Mother Name</td>
            <td><form:input path="motherName"/></td>
         </tr>
         
         <tr>
            <td>Date of Birth</td>
            <td><form:input path="dob" id="datepicker"/></td>
         </tr>
         <tr>
            <td>Gender</td>
            <td><form:radiobutton value="M" path="gender"/>Male</td>
            <td><form:radiobutton value="F" path="gender"/>Fe-male</td>
         </tr>
         <tr>
			<td><b>Select State :</b></td>
			<td><form:select path="state" items="${stateList}" /></td>
		</tr>
         <tr>
           <td><input type="reset" value="Reset"></td>
           <td><input type="submit" value="SUBMIT"></td>
         </tr>
      </table>
  </form:form>
</body>
</html>