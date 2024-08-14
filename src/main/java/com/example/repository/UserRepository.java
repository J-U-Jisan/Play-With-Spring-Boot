package com.example.repository;

import com.example.domain.user.model.MUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MUser, String> {
}
