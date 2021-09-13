package com.s1dmlgus.jpaShop02.domain.member;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

}
