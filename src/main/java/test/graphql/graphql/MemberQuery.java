package test.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import test.graphql.domain.Member;
import test.graphql.dto.MemberDto;
import test.graphql.exception.MemberNotFoundException;
import test.graphql.repository.MemberRepository;

@Component
@Transactional
@RequiredArgsConstructor
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberRepository memberRepository;

    public MemberDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
        return MemberDto.from(member);
    }
}
