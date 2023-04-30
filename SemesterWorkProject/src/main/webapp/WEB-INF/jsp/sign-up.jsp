<%--
  Created by IntelliJ IDEA.
  User: anpud
  Date: 22.04.2023
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="SignUp">
    <div class="parent-container">
    <div class="registration-form">
        <form:form method="post" modelAttribute="user">
            <div class="form-name">
                <h2>Registration</h2>
            </div>
            <div class="form-group">
                <form:label  path="username">Username</form:label>
                <form:input cssClass="form-control item" path="username" maxlength="20"/>
                <form:errors path="username" />
            </div>
            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:password cssClass="form-control item" path="password"/>
                <form:errors path="password" />
            </div>
            <div class="form-button">
                <button type="submit" class="btn btn-block create-account">Sign Up</button>
            </div>
        </form:form>
        <p>${errorFields}</p>
        <p>${error}</p>
    </div>
    </div>
</t:mainLayout>
