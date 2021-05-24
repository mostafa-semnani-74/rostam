package ir.mostafa.semnani.rostambackend.common.security.user;

import ir.mostafa.semnani.rostambackend.common.exception.RoleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDA roleDA;

    @Transactional
    public void create(Role role) { roleDA.save(role); }

    @Transactional
    public void delete(Long id) { roleDA.deleteById(id); }

    @Transactional
    public Role update(Role role , Long id) {
        Role roleForUpdate = roleDA.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("role not exist with id :" + id) );

        roleForUpdate.setRole(role.getRole());

        roleDA.save(roleForUpdate);
        return roleForUpdate;
    }

    public List<Role> findAll() { return roleDA.findAll(); }
    public Role findById(Long id) { return roleDA.findById(id)
            .orElseThrow(() -> new RoleNotFoundException("role not exist with id :" + id) ); }
}
