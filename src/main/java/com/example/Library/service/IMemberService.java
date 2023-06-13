package com.example.Library.service;

import java.util.List;




import com.example.Library.Entity.Member;




public interface IMemberService {

public Member getMemberById(int memberId);




public Member addMember(Member Member);




public Member editMember(int memberId, Member Member);




public boolean deleteMember(int memberId);




public List<Member> getMembers();




//public List<Object[]> getAllMemberWithBook();




}