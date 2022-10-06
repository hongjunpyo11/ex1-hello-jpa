package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    /** 값 타입 컬렉션 (값 타입 컬렉션도 지연 로딩 전략 사용)
     * * 값 타입을 하나 이상 저장할 때 사용
     * * @ElementCollection, @CollectionTable 사용
     * * 데이터베이스는 컬렉션을 같은 테이블에 저장할 수 없다.
     * * 컬렉션을 저장하기 위한 별도의 테이블이 필요함
     * ==============================================================
     * * 참고: 값 타입 컬렉션은 영속성 전이에(Cascade) + 고아 객체 제거 기능을 필수로 가진다고 볼 수 있다.
     */

    /** 값 타입 컬렉션의 제약사항
     * * 값 타입은 엔티티와 다르게 식별자 개념이 없다.
     * * 값은 변경하면 추적이 어렵다
     * * 값 타입 컬렉션에 변경 사항이 발생하면, 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 컬렉션에 있는 현재 값을 모두 다시 저장한다.
     * * 값 타입 컬렉션을 매핑하는 테이블은 모든 컬럼을 묶어서 기본 키를 구성해야 함: null 입력 X, 중복 저장 X
     */

    /** 값 타입 컬렉션 대안
     * 실무에서는 상황에 따라 값 타입 컬렉션 대신에 일대다 관계를 고려
     * 일대다 관계를 위한 엔티티를 만들고, 여기에서 값 타입을 사용
     * Cascade + 고아 객체 제거를 사용해서 값 타입 컬렉션 처럼 사용
     */

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
