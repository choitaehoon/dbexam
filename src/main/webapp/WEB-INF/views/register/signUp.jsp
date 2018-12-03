<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body { font-family: 굴림체; }
        input.form-control { width: 200px; }
        select.form-control { width: 200px;}
    </style>
</head>
<body>
    <div class="container">
        <h1>회원가입</h1>
        <hr/>
        <form:form method="post" modelAttribute="user">

            <div class="form-group">
                <label>사용자 아이디</label>
                <input type="text" class="form-control" name="id" value="${member.id}"/>
            </div>

            <div class="form-group">
                <label>이름</label>
                <input type="text" class="form-control" name="name" value="${member.name}"/>
            </div>

            <div class="form-group">
                <label>비밀번호</label>
                <input type="password" class="form-control" name="password" value="${member.password}"/>
            </div>

            <div class="form-group">
                <label>이메일</label>
                <input type="email" class="form-control" name="email" value="${member.email}"/>
            </div>

            <div class="form-group">
                <label>핸드폰</label>
                <input type="text" class="form-control" name="phone" value="${member.phone}"/>
            </div>

            <c:if test="${type == 1}">
            <div class="form-group">
                <label>학년</label>
                <input type="text" class="form-control" name="year" value="${member.year}"/>
            </div>
            </c:if>

            <div class="form-group">
                <label>학과</label>
                <form:select path="department_id" class="form-control"
                itemValue="id" itemLabel="departmentName" items="${departments}"></form:select>
            </div>

            <div class="form-group">
                <label>성별</label>
                <select name="sex" class="form-control">
                    <option value="1">남자</option>
                    <option value="2">여자 </option>
                </select>
            </div>

            <c:if test="${type == 1}">
                <input type="hidden" name="graduationRule_id" value="1">
            </c:if>
            <input type="hidden" name="type" value="${type}">
        <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-ok"></i> 회원가입</button>
            <a href="../login.jsp"> <button type="button" class="btn btn-success">목록으로 가기</button></a>

        </form:form>

    </div>
</body>
</html>