package ir.mostafa.semnani.rostambackend.common.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDA extends JpaRepository<Role , Long> {

}
