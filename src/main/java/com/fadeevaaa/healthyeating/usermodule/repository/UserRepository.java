package com.fadeevaaa.healthyeating.usermodule.repository;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
