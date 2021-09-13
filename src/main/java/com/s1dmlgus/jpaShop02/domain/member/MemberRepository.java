package com.s1dmlgus.jpaShop02.domain.member;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;


    public void save(Member member){
        em.persist(member);
    }


    public List<Member> findByName(String memberName) {

        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class)
                .setParameter("name",memberName)
                .getResultList();
    }


    public List<Member> findByAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }
}
