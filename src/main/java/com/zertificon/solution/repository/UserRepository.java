package com.zertificon.solution.repository;

import com.zertificon.solution.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hamidreza on 6/12/2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
