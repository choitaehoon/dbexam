package net.skhu.db.mapper;

import net.skhu.db.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper
{
    void insert(Admin admin);
    void update(Admin admin);
}
