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
   <h1>회원 수정</h1>
    <hr/>
    <form:form method="post" modelAttribute="user" action="/login/update1">
            <div class="form-group">
                <label>사용자 아이디</label>
                <input type="text" class="form-control" name="id" value="${member.id}" readonly/>
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
                <select name="department_id" class="form-control">
                    <option value="1" ${selected[1]}>소프트웨어공학과</option>
                    <option value="2" ${selected[2]}>컴퓨터공학과</option>
                    <option value="3" ${selected[3]}>글로컬IT학과</option>
                    <option value="4" ${selected[4]}>정보통신공학과</option>
                    <option value="5" ${selected[5]}>디지털컨텐츠학과</option>
                    <option value="6" ${selected[6]}>경영학과</option>
                    <option value="7" ${selected[7]}>신문방송학과</option>
                    <option value="8" ${selected[8]}>사회과학부</option>
                    <option value="9" ${selected[9]}>사회복지학과</option>
                    <option value="10" ${selected[10]}>중어중국학과</option>
                    <option value="11" ${selected[11]}>일어일본학과</option>
                    <option value="12" ${selected[12]}>영어학과</option>
                    <option value="13" ${selected[13]}>신학과</option>
                    <option value="14" ${selected[14]}>인문융합자율학부</option>
                    <option value="15" ${selected[15]}>사회융합자율학부</option>
                    <option value="16" ${selected[16]}>미디어컨텐츠융합자율학부</option>
                    <option value="17" ${selected[17]}>IT융합자율학부</option>
                    <option value="18" ${selected[18]}>열림교양대학</option>
                    <option value="19" ${selected[19]}>임시배치</option>
                </select>
            </div>

            <div class="form-group">
                <label>성별</label>
                <select name="sex" class="form-control">
                    <option value="1" ${selected1[1]}>남자</option>
                    <option value="2" ${selected1[2]}>여자 </option>
                </select>
            </div>

            <c:if test="${type == 1}">
                <input type="hidden" name="graduationRule_id" value="1">
            </c:if>
            <input type="hidden" name="type" value="${type}">
                <button type="submit" class="btn btn-primary">수정하기</button>

        </form:form>


        <form action="/login/signIn" method="post">
            <input type="hidden" name="id" value="${member.id}">
            <input type="hidden" name="password" value="${member.password}">
            <button type="submit" class="btn btn-success" >목록으로 가기</button>
        </form>

</div>
</body>
</html>
