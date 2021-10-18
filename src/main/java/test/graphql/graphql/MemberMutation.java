package test.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import test.graphql.domain.Member;
import test.graphql.domain.Role;
import test.graphql.dto.MemberDto;
import test.graphql.exception.MemberNotFoundException;
import test.graphql.repository.MemberRepository;
import test.graphql.repository.RoleRepository;

@Component
@Transactional
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    public MemberDto createMember(MemberDto memberDto) {
        Member member = memberRepository.save(memberDto.toEntity());
        return MemberDto.from(member);
    }

    public Boolean deleteMember(Long id) {
        try {
            Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
            Role role = roleRepository.findByMemberId(member.getId());

            roleRepository.delete(role);
            memberRepository.delete(member);
        } catch (Exception exception) {
            return false;
        }
        return true;
    }
}
