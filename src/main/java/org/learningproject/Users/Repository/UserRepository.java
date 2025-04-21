package org.learningproject.Users.Repository;

import org.learningproject.Users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findUserByEmail(String email);

    boolean findUserByPassword(String password);

    boolean existsByEmail(String email);

    boolean existsByPassword(String password);
}
