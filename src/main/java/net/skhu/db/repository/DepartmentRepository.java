package net.skhu.db.repository;

import net.skhu.db.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{

}
