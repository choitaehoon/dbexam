package net.skhu.db.mapper;

import net.skhu.db.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper
{
    void insert(Student student);
    void update(Student student);
}
