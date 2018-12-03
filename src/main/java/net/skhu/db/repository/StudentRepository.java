package net.skhu.db.repository;

import net.skhu.db.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    int countByIdAndPassword(int id,String password);
    Student findById(int id);
}
