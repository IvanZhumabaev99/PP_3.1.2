package ru.zhumabaev.springcourse.PP311.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zhumabaev.springcourse.PP311.model.User;

//вместо DAO
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> { //вместо DAO

}
