package com.example.Library.repository;

import com.example.Library.Entity.Member;




import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;




@Repository

public interface MemberRepository extends JpaRepository<Member, Integer> {

}