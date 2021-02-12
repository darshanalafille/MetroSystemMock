package com.metro.user.repo;

import com.metro.user.entiry.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByIdNumberAndPin(@Param("idNumber") String idNumber,@Param("pin") String pin);

}
