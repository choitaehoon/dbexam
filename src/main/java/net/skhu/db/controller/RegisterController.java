package net.skhu.db.controller;

import net.skhu.db.domain.User;
import net.skhu.db.repository.DepartmentRepository;
import net.skhu.db.repository.StudentRepository;
import net.skhu.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("register")
public class RegisterController
{
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UserService userService;

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String register(Model model, User user, @RequestParam("type") int type)
    {
        model.addAttribute("departments",departmentRepository.findAll());
        model.addAttribute("type",type);
        return "register/signUp";
    }

    @RequestMapping(value = "signUp",method = RequestMethod.POST)
    public String signUp(User user, @RequestParam("type") int type)
    {
        userService.insert(type,user);
        return "redirect:../login.jsp";
    }
}
