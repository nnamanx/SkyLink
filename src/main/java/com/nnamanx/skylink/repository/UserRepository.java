package com.nnamanx.skylink.repository;

import com.nnamanx.skylink.model.entity.EndUser;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<EndUser, Long> {
    Optional<EndUser> findByUsername(String username);

    Optional<Object> findByEmail(String email);

    @Query("SELECT u FROM EndUser u WHERE u.confirmationToken = :confirmationToken")
    Optional<EndUser> findByConfirmationToken(@Param("confirmationToken") String confirmationToken);
}
