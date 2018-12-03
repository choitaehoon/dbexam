package net.skhu.db.repository;

import net.skhu.db.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{
    Admin findById(int id);
}
