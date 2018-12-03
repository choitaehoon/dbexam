package net.skhu.db.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User
{
    @Id
    int id;
    String name;
    String password;
    String email;
    String phone;
    int department_id;
    int graduationRule_id;
    int sex;
    int year;
}
