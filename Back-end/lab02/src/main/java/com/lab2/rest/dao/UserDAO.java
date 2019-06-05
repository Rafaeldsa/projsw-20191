package com.lab2.rest.dao;

import com.lab2.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserDAO<T, ID extends Serializable> extends JpaRepository<User, String> {

    User save(User user);

    @Query(value="Select u from User u where u.login=:plogin")
    User findByLogin(@Param("plogin") String login);

}
