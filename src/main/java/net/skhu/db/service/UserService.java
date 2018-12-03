package net.skhu.db.service;

import net.skhu.db.domain.Admin;
import net.skhu.db.domain.Student;
import net.skhu.db.domain.User;
import net.skhu.db.mapper.AdminMapper;
import net.skhu.db.mapper.StudentMapper;
import net.skhu.db.repository.AdminRepository;
import net.skhu.db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;

    public void insert(int type, User user) {
        if (type == 1) {
            Student student = new Student();
            student.setId(user.getId());
            student.setName(user.getName());
            student.setPassword(user.getPassword());
            student.setEmail(user.getEmail());
            student.setPhone(user.getPhone());
            student.setDepartment_id(user.getDepartment_id());
            student.setGraduationRule_id(user.getGraduationRule_id());
            student.setSex(user.getSex());
            student.setYear(user.getYear());
            studentMapper.insert(student);
        } else {
            Admin admin = new Admin();
            admin.setId(user.getId());
            admin.setName(user.getName());
            admin.setPassword(user.getPassword());
            admin.setEmail(user.getEmail());
            admin.setPhone(user.getPhone());
            admin.setDepartment_id(user.getDepartment_id());
            admin.setSex(user.getSex());
            adminMapper.insert(admin);
        }
    }

    public Object check(User user) {
        if (studentRepository.countByIdAndPassword(user.getId(), user.getPassword()) == 1)
            return studentRepository.findById(user.getId());
        else
            return adminRepository.findById(user.getId());
    }

    public int checkUser(User user) {
        if (studentRepository.countByIdAndPassword(user.getId(), user.getPassword()) == 1)
            return 1;
        else
            return 2;
    }

    public void updateCheck(int type, User user) {
        if (type == 1) {
            Student student = new Student();
            student.setId(user.getId());
            student.setName(user.getName());
            student.setPassword(user.getPassword());
            student.setEmail(user.getEmail());
            student.setPhone(user.getPhone());
            student.setDepartment_id(user.getDepartment_id());
            student.setSex(user.getSex());
            student.setYear(user.getYear());
            studentMapper.update(student);
        } else {
            Admin admin = new Admin();
            admin.setId(user.getId());
            admin.setName(user.getName());
            admin.setPassword(user.getPassword());
            admin.setEmail(user.getEmail());
            admin.setPhone(user.getPhone());
            admin.setDepartment_id(user.getDepartment_id());
            admin.setSex(user.getSex());
            adminMapper.update(admin);
        }
    }

    public String[] selectedCheck(User user) {
        int department_id = 0;
        if (checkUser(user) == 1) //학생이면
            department_id = studentRepository.findById(user.getId()).getDepartment_id();
        else
            department_id = adminRepository.findById(user.getId()).getDepartment_id();
        String[] temp = new String[21];
        for (int i = 1; i < 21; ++i)
            if (i == department_id)
                temp[i] = "selected";
        return temp;
    }


    public String[] selectSex(User user)
    {
        int sex = 0;
        if (checkUser(user) == 1)
            sex = studentRepository.findById(user.getId()).getSex();
        else
            sex = adminRepository.findById(user.getId()).getSex();
        String[] temp = new String[3];
        for(int i=1; i<3; ++i)
            if (i == sex)
                temp[i] = "selected";
            return temp;
    }
}
