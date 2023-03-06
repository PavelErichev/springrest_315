package ru.Kata.Erichev.springrest_315.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.Kata.Erichev.springrest_315.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value = "select r from Role r where r.name= :name")
    Role getByName(@Param("name") String name);
}