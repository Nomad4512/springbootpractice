package com.example.myproject;

import com.example.myproject.repository.MemberRepository;
import com.example.myproject.repository.MemoryMemberRepository;
import com.example.myproject.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // @Service @Repository를 하지않고 직접 스프링 빈 등록
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    /*
     * 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
     * 그리고 정형화 되지않거나, 상황에 따라 구현 클래스를 변경해야하면 설정을 통해
     * 스프링 빈으로 등록한다.
     */

}
