package com.joonseolee.adapter.persistence;

import com.joonseolee.adapter.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Collection<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
