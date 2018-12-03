<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>아이디:${member.id} 이름:${member.name}님 비밀번호:${member.password} 휴대폰번호:${member.phone} </h1>
        <div class="pull-right" style="margin-right:10px;">
            <button class="btn btn-primary" onclick="window.open('myLecExcel?type=${type}&id=${member.id}','classUpload','width=600,height=300,location=no,status=no,scrollbars=yes');">수강내역 엑셀 업로드</button>
        </div>
        <div class="pull-right">
            <form action="/login/update" method="post">
                <input type="hidden" name="id" value="${member.id}">
                <input type="hidden" name="password" value="${member.password}">
                <button type="submit"><i class="btn btn-primary">회원 수정</i></button>
            </form>
        </div>
        <div class="pull-right">
            <a href="../login.jsp"><i class="btn btn-success">로그아웃</i></a>
        </div>

        <c:if test="${type == 1}">
        <div class="header">

            <form>
                <input type="hidden" name="id" value="${member.id}">
                <input type="hidden" name="password" value="${member.password}">
                <select name="count">
                    <option value="1">년도</option>
                    <option value="2">학기</option>
                    <option value="3">과목코드</option>
                    <option value="4">과목명</option>
                    <option value="5">이수구분</option>
                </select>
                <input type="text" name="search">
                <button type="submit" class="btn btn-default">조회</button>
            </form>

            <table class="table table-stript" style="width:100%; max-width:100%; margin-bottom:20px;">
                <thead>
                <tr>
                    <th>년도</th>
                    <th>학기</th>
                    <th>과목코드</th>
                    <th>과목명</th>
                    <th>이수구분</th>
                    <th>학점</th>
                    <th>성적등급</th>
                </tr>

                </thead>


                <tbody>
                <c:forEach var="lecture" items="${ myLecture }">
                    <c:if test="${member.id == lecture.student_id}">
                        <tr>
                            <td>${ lecture.lecture_year }</td>
                            <td>${ lecture.lecture_semester }</td>
                            <td>${ lecture.lecture_id }</td>
                            <td>${ lecture.title }</td>
                            <td>${ lecture.detailType }</td>
                            <td>${ lecture.credit }</td>
                            <td>${ lecture.grade }</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
            </c:if>


            <c:if test="${type == 2}">
            <div class="header">

                <form>
                    <input type="hidden" name="id" value="${member.id}">
                    <input type="hidden" name="password" value="${member.password}">
                    <select name="count">
                        <option value="1">년도</option>
                        <option value="2">학기</option>
                        <option value="3">과목코드</option>
                        <option value="4">과목명</option>
                        <option value="5">이수구분</option>
                    </select>
                    <input type="text" name="search">
                    <button type="submit" class="btn btn-default">조회</button>
                </form>

                <table class="table table-stript" style="width:100%; max-width:100%; margin-bottom:20px;">
                    <thead>
                    <tr>
                        <th>년도</th>
                        <th>학기</th>
                        <th>과목코드</th>
                        <th>과목명</th>
                        <th>이수구분</th>
                        <th>학점</th>
                    </tr>

                    </thead>


                    <tbody>
                    <c:forEach var="lecture" items="${ lectures }">
                        <tr>
                            <td>${ lecture.year }</td>
                            <td>${ lecture.semester }</td>
                            <td>${ lecture.id }</td>
                            <td>${ lecture.title }</td>
                            <td>${ lecture.subType }</td>
                            <td>${ lecture.credit }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
