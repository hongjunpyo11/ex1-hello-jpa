package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") // 객체의 양방향 관계는 사실 양방향이 아니라 서로 다른 단방향 관계 2개이다. 외래키가 있는 곳을 주인으로 정하라! 외래키는 N쪽에 있을 것이다. 다(N) 쪽이 연관관계 주인이 된다고 생각
    private List<Member> members = new ArrayList<>(); // ArrayList로 초기화 일종의 관례 add 할때 nullpointer가 안뜨도록

    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
