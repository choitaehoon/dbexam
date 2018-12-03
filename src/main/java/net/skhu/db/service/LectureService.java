package net.skhu.db.service;

import net.skhu.db.domain.Lecture;
import net.skhu.db.excel.ExcelRead;
import net.skhu.db.excel.ExcelReadOption;
import net.skhu.db.mapper.LectureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class LectureService
{
    @Autowired
    LectureMapper lectureMapper;
    /*
수업관리,
과목 엑셀업로드
*/
    public void excelUpload(File destFile) throws Exception {
        //엑셀 데이터를 읽기전 (경로, 컬럼, 추출할 행) 옵션 클래스 선언
        ExcelReadOption excelReadOption = new ExcelReadOption();
        //파일을 옵션에 담기
        excelReadOption.setFilePath(destFile.getAbsolutePath());
        //엑셀에서 읽을 컬럼 명 지정
        excelReadOption.setOutputColumns("B","C","D","E","F","G","H","I");
//        excelReadOption.setOutputColumns("A","B","C","D","E","F","G","H");
        //첫번째행은 컬럼명이여서 제외하고, 2번째부터 데이터 값 받기위해 설정
        excelReadOption.setStartRow(2);
        //엑셀파일 읽기어서 맵에 담기
        List<Map<String, String>> excelContent = ExcelRead.read(excelReadOption);

        //데이터를 담기위한 객체 선언
        Lecture lecture=null;

        //article.get() 리턴 타입이 String 이기때문에 int 형은 형변환을 해줘야한다.
        for (Map<String, String> article : excelContent) {
            //객체 안에 엑셀 데이터값 받아서 넣기
            lecture=new Lecture();
            lecture.setYear(Integer.valueOf(article.get("A"))); //년도
            lecture.setSemester(article.get("B")); //학기
            lecture.setId(article.get("C")); //과목코드
            lecture.setSplit(Integer.valueOf(article.get("D"))); //분반
            lecture.setTitle(article.get("E")); //교과목명
            lecture.setAdmin_id(Integer.valueOf(article.get("F"))); //교수코드
            lecture.setCredit(Integer.valueOf(article.get("G"))); //학점
            lecture.setSubType(article.get("H")); //이수구분




            //데이터값을 잘 가져오는 지 확인하기 위해
//            System.out.println(article.get("A"));
//            System.out.println(article.get("B"));
//            System.out.println(article.get("C"));
//            System.out.println(article.get("D"));
//            System.out.println(article.get("E"));
//            System.out.println(article.get("F"));
//            System.out.println(article.get("G"));
//            System.out.println(article.get("H"));

            //데이터 한개 행 담은 객체 insert
            this.lecInsert(lecture);

        }
    }

    /*과목 등록*/
    public void lecInsert(Lecture lecture){
        lectureMapper.insert(lecture);
    }

}
