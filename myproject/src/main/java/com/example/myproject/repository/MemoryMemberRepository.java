package com.example.myproject.repository;

import com.example.myproject.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀀스값을 먼저 올려주고
        store.put(member.getId(),member); // 아이디를 넣고
        return member; // 리턴
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store에서 꺼낼건데 결과가 없어도 되게
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // name 이 같으면 반환
                .findAny(); // 하나라도 찾으면 결과가 Optional로 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
