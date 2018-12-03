package net.skhu.db.controller;

import net.skhu.db.domain.User;
import net.skhu.db.mapper.LectureMapper;
import net.skhu.db.mapper.MyLectureMapper;
import net.skhu.db.repository.DepartmentRepository;
import net.skhu.db.service.LectureService;
import net.skhu.db.service.MyLecService;
import net.skhu.db.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController
{
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    UserService userService;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    LectureService lectureService;
    @Autowired
    MyLecService myLecService;
    @Autowired
    MyLectureMapper myLectureMapper;
    @Autowired
    LectureMapper lectureMapper;


    @RequestMapping(value = "signIn")
    public String signIn(Model model, User user, @RequestParam(value = "count" ,defaultValue = "0") int count,@RequestParam(value = "search",defaultValue = "") String search)
    {
        model.addAttribute("member",userService.check(user));
        model.addAttribute("type",userService.checkUser(user));
        if (userService.checkUser(user) == 1 && count ==0)
            model.addAttribute("myLecture",myLectureMapper.findAll());
        else if (userService.checkUser(user) == 2 && count == 0)
            model.addAttribute("lectures",lectureMapper.findAll());
        else if(userService.checkUser(user) == 1 && count >=1)
            model.addAttribute("myLecture", myLectureMapper.findSearch(count, search));
        else
            model.addAttribute("lectures", lectureMapper.findSearch(count,search));
        return "login/signIn";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Model model, User user)
    {
        model.addAttribute("member",userService.check(user));
        model.addAttribute("departments",departmentRepository.findAll());
        model.addAttribute("type",userService.checkUser(user));
        model.addAttribute("selected",userService.selectedCheck(user));
        model.addAttribute("selected1",userService.selectSex(user));
        return "login/update";
    }

    @RequestMapping("update1")
    public String update(User user, @RequestParam("type") int type, RedirectAttributes redirectAttributes)
    {
        userService.updateCheck(type,user);
        redirectAttributes.addAttribute("id",user.getId());
        redirectAttributes.addAttribute("password",user.getPassword());
        return "redirect:signIn";
    }

    /*엑셀업로드 내가수강한수업 엑셀업로드 페이지 */
    @RequestMapping("myLecExcel")
    public String myLecExcel (Model model, @RequestParam("id") int id, @RequestParam("type") int type)
    {
        model.addAttribute("id",id);
        model.addAttribute("type", type);
        return "login/myLecExcel";
    }

    /*
엑셀업로드, 등록
 */
    @ResponseBody
    @RequestMapping(value = "/excelUploadAjax", method = RequestMethod.POST)
    public String excelUploadAjax(MultipartHttpServletRequest request, @RequestParam("type") int type, @RequestParam("id") int id, RedirectAttributes redirectAttributes) throws Exception {
        MultipartFile excelFile = request.getFile("excelFile");
        System.out.println("엑셀 파일 업로드 컨트롤러");
        if (excelFile == null || excelFile.isEmpty()) {
            throw new RuntimeException("엑셀파일을 선택 해 주세요.");
        }

//        엑셀파일이 c 디스크에 있어야함
        File destFile = new File("C:\\upload\\" + excelFile.getOriginalFilename());

        try {
            excelFile.transferTo(destFile);
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        //관리자일때,수업리스트 업로드
        if (type == 2) {
            lectureService.excelUpload(destFile);
        }
        //학생일때, 내가 수강한 과목 업로드
        else if (type == 1) {
            myLecService.excelUpload(destFile, id);
        }

        redirectAttributes.addAttribute("type", type);
        redirectAttributes.addAttribute("id", id);
        return "수강과목 엑셀파일이 업로드 되었습니다.새로고침 눌러주세요!";
    }

}
