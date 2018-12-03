package net.skhu.db.mapper;

import net.skhu.db.domain.MyLecture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyLectureMapper
{
    void insert(MyLecture myLecture);
    List<MyLecture> findAll();
    List<MyLecture> findSearch(@Param("count") int count , @Param("search") String search);
}
