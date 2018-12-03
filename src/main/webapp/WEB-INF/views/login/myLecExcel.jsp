<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="javascript">
        // 엑셀업로드 function
        function checkFileType(filePath) {
            var fileFormat = filePath.split(".");
            if (fileFormat.indexOf("xlsx") > -1) {
                return true;
            } else {
                return false;
            }
        }

        function check() {
            var file = $("#excelFile").val();
            if (file == "" || file == null) {
                alert("파일을 선택해주세요.");
                return false;
            } else if (!checkFileType(file)) {
                alert("엑셀 파일만 업로드 가능합니다.");
                return false;
            }

            if (confirm("업로드 하시겠습니까?")) {
                var options = {
                    success: function (data) {
                        alert("모든 데이터가 업로드 되었습니다.");

                    },
                    type: "POST"
                };
                $("#excelUploadForm").ajaxSubmit(options);

            }
        }
    </script>
</head>
<body>
<br><br>
<div id="content">
    <form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data" method="post"
          action= "${pageContext.request.contextPath}/login/excelUploadAjax?type=${type}&id=${id}">
        <div class="contents">
            <div>
                <h3>내가 수강한 수업 엑셀 업로드</h3>
                <p style="color: #9368E9">c드라이브에 upload 폴더를 만든 후<br>
                    엑셀파일을 넣고 파일을 불러와 주세요</p>
                <br>
                <p>첨부파일은 한개만 등록 가능합니다.</p>

            </div>

            <dl class="vm_name">
                <dt class="down w90">첨부 파일</dt>
                <dd><input id="excelFile" type="file" name="excelFile" /></dd>
            </dl>
        </div>

        <div class="bottom">
            <button type="submit" id="addExcelImpoartBtn" class="btn btn-info" onclick="check()"><span>추가</span></button>
        </div>
    </form>

</div>
</body>
</html>
