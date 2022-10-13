package hellojpa;

import org.hibernate.Criteria;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER")
                            .getResultList();

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

/** 네이티브 SQL 소개
 *  * JPA가 제공하는 SQL을 직접 사용하는 기능
 *  * JPQL로 해결할 수 없는 특정 데이터베이스에 의존적인 기능
 *  * 예) 오라클 CONNECT BY, 특정 DB만 사용하는 SQL 힌트
 */
