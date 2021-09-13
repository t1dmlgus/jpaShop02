package com.s1dmlgus.jpaShop02.service;


import com.s1dmlgus.jpaShop02.domain.member.Member;
import com.s1dmlgus.jpaShop02.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    public MemberRepository memberRepository;

    // 회원가입
    public void join(Member member) {

        validateDuplicateMember(member);

        memberRepository.save(member);
    }

    // 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
}
