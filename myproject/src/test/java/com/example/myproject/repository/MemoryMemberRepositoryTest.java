package com.example.myproject.repository;

import com.example.myproject.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*; // Assertions.assertThat 이부분을 static import함

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트는 서로 순서,의존관계와 상관없이 설계되어야 한다.
    @AfterEach
    public void afterEach(){ // 테스트 하나가 끝나고 저장소 정리
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = "+ (result == member)); 이렇게하면 글자를 볼 수 없다.
        // Assertions.assertEquals(member, result);
       assertThat(member).isEqualTo(result); // member가 result와 같을 때

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift f6으로 rename
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift f6으로 rename
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
