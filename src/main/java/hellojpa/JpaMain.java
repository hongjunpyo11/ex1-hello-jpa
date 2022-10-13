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

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            //flush -> commit, query

            em.flush();

            // 결과 0
            //dbconn.executeQuery("select * from member");

            // iter
            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1); // soutv
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

/** JDBC 직접 사용, SpringJdbcTemplate 등
 *  * JPA를 사용하면서 JDBC 커넥션을 직접 사용하거나, 스프링 JdbcTemplate, 마이바티스등을 함께 사용 가능
 *  * 단 영속성 컨텍스트를 적절한 시점에 강제로 플러시 필요
 *  * 예) JPA를 우회해서 SQL을 실행하기 직전에 영속성 컨텍스틀 수동 플러시
 */
