package test.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import test.graphql.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
