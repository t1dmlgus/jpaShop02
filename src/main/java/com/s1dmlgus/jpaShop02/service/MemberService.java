package com.s1dmlgus.jpaShop02.service;


import com.s1dmlgus.jpaShop02.domain.member.Member;
import com.s1dmlgus.jpaShop02.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    public MemberRepository memberRepository;

    // 회원가입
    public void join(Member member) {
        memberRepository.save(member);
    }
}
