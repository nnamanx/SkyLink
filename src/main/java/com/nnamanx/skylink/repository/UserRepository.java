package com.nnamanx.skylink.repository;

import com.nnamanx.skylink.model.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EndUser, Long> {
}