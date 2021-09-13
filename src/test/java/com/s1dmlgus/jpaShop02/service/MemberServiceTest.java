package com.s1dmlgus.jpaShop02.service;

import com.s1dmlgus.jpaShop02.domain.member.Member;
import com.s1dmlgus.jpaShop02.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;



@Transactional
@SpringBootTest
class MemberServiceTest {

    /**
     * 회원 기능에서 검증해야 할 비즈니스 로직
     * 
     * 1. 회원가입을 성공해야 한다.
     * 2. 회원가입 할 때 중복된 이름이 있으면 예외가 발생한다.
     */

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @DisplayName("회원가입 테스트")
    @Test
    public void testJoin() throws Exception{
        //given
        Member member = new Member();
        member.setName("의현");

        //when
        Long saveId = memberService.join(member);

        //then
        assertThat(memberRepository.findOne(saveId)).isEqualTo(member);
    }

    @DisplayName("중복된 회원 이름이 있는지 예외 처리 테스트")
    @Test
    public void testDuplicateName() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("의현2");

        Member member2 = new Member();
        member2.setName("의현2");

        //when
        memberService.join(member1);

        //then
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 존재하는 회원입니다");


    }


}