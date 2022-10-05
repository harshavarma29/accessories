package com.accessories.repository;

import com.accessories.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "select * from users where email = :email and password = :password", nativeQuery = true)
    Users findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
