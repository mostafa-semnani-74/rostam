package ir.mostafa.semnani.rostambackend.common.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDA extends JpaRepository<User , Long> {

    User getByUsername(String username);
}
