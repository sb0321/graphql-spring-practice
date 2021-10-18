package test.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import test.graphql.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByMemberId(Long id);
}
