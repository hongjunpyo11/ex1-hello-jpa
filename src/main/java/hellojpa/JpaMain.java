package hellojpa;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            List<Member> result = em.createQuery(
                    "select  m from Member  m where m.username like '%kim%'",
                    Member.class
            ).getResultList();

            for (Member member : result) {
                System.out.println("member = " + member);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}

/**
 * JPQL 소개
 * JPA를 사용하면 엔티티 객체를 중심으로 개발
 * 문제는 검색 쿼리
 * 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
 * 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능
 * 애플릭케이션이 필요한 데이터만 DB에 불러오려면 결국 검색 조건이 포함된 SQL이 필요
 *
 * JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어 제공
 * SQL 문법과 유사
 * JPQL은 엔티티 객체를 대상으로 쿼리
 * SQL은 데이터베이스 테이블을 대상으로 쿼리
 *
 * 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
 * SQL을 추상화해서 특정 데이터베이스 SQL에 의존 X
 * JPQL을 한마디로 정의하면 객체 지향 SQL
 */
