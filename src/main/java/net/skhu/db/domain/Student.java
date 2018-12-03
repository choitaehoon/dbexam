package net.skhu.db.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Student
{
    @Id
    int id;
    String name;
    String password;
    String email;
    String phone;
    String comment;
    Double totalCredit;
    Double avgGrade;
    Double avgMajor;
    String question;
    int department_id;
    int graduationRule_id;
    int sex;
    int year;
//    int type;
}
