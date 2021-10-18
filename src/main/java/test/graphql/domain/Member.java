package test.graphql.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

    private String password;

    private String name;

    @OneToMany
    @JoinColumn(name = "memberId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Role> role;
}