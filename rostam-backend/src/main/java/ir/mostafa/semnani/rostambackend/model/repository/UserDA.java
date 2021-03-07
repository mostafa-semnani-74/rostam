package ir.mostafa.semnani.rostambackend.model.repository;

import ir.mostafa.semnani.rostambackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDA extends JpaRepository<User, Long> {
    User getByUsername(String username);

}
