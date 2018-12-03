package net.skhu.db.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MyLecture
{
    @Id
    int id;
    int lecture_year;
    String lecture_semester;
    String lecture_id;
    int lecture_split;
    String title;
    String detailType;
    String credit;
    String grade;
    int student_id;
    int remove;

}
