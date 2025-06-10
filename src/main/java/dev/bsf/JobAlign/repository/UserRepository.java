package dev.bsf.JobAlign.repository;

import dev.bsf.JobAlign.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
