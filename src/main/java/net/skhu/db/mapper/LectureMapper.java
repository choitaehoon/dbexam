package net.skhu.db.mapper;

import net.skhu.db.domain.Lecture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LectureMapper
{
    void insert(Lecture lecture);
    List<Lecture> findAll();
    List<Lecture> findSearch(@Param("count") int count, @Param("search") String search);
}
