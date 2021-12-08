<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

      <div align="center">
        <h1>New/Edit Employee</h1>
        <form:form action="saveData" method="post" modelAttribute="employee">
        <table>
      
            <form:hidden path="employeeId"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Project Details:</td>
                <td><form:input path="project" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="mailId" /></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><form:input path="phoneNo" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        
        </table>
        </form:form>
    </div>
</body>
</html>