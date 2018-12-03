package net.skhu.db.domain;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Admin
{
    @Id
    int id;
    String name;
    String password;
    String email;
    String phone;
    int department_id;
    int sex;

//    int type;
}
