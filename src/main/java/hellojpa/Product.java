package hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    /*
    다대다 매핑의 한계
    편리해 보이지만 실무에서 사용 X
    연결 테이블이 단순히 연결만 하고 끝나지 않음
    주문시간, 수량 같은 데이터가 들어올 수 있음

    다대다의 한계 극복
    연결 테이블용 엔티티 추가
    @ManyToMany -> @OneToMany, @ManyToOne
     */

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
