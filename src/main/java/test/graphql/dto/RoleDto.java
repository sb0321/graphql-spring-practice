package test.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import test.graphql.domain.Role;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private Long memberId;
    private String role;

    public static List<RoleDto> from(Collection<Role> roles) {
        return roles.stream().map(RoleDto::from).collect(Collectors.toList());
    }

    public static RoleDto from(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .memberId(role.getMemberId())
                .role(role.getRole())
                .build();
    }
}
