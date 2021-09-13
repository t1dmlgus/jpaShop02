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
     * - 회원가입을 성공해야 한다.
     * - 회원가입 할 때 같은 이름이 있으면 예외가 발생한다.
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




}