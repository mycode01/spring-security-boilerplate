package com.example.jpa.repo;

import com.example.jpa.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
     Optional<Member> findByUid(String uid);
}
