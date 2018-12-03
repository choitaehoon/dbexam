<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body>
<div class="container">
    <h1>로그인</h1>
    <hr/>

    <form action="/login/signIn">
        <div class="form-group">
            <label>사용자 아이디</label>
            <input type="text" class="form-control" name="id"/>
        </div>

        <div class="form-group">
            <label>비밀번호</label>
            <input type="password" class="form-control" name="password"/>
        </div>

        <button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-ok"></i> 로그인</button>
    </form>

    <form action="/register/signUp">
        <div>
            <input type="radio" name="type" value="1">학생
            <input type="radio" name="type" value="2">교수
        </div>
        <button type="submit" class="btn btn-default"> <i class="glyphicon glyphicon-user"></i>회원가입</button>
    </form>

</div>
</body>
</html>
