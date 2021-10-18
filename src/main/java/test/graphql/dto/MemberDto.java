package test.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import test.graphql.domain.Member;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private List<RoleDto> roles;


    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .name(member.getName())
                .roles(RoleDto.from(member.getRole()))
                .build();
    }

    public Member toEntity() {
        return Member
                .builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .name(name)
                .build();
    }

}
