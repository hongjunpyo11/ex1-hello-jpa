package hellojpa;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)
public class Member {

    @Id // 직접 할당 @ID만 사용, 자동 생성(@GeneratedValue)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR") // IDENTITY: 기본키 생성을 데이터 베이스에 위임, 권장 Long + 대체키 + 키 생성전략 사용
    private Long id;

    @Column(name = "name", nullable = false) // 컬럼 매핑 nullable
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
