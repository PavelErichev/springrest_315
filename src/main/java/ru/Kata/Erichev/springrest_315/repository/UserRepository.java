package ru.Kata.Erichev.springrest_315.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Kata.Erichev.springrest_315.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}