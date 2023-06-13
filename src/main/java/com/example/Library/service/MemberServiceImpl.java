package com.example.Library.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




import com.example.Library.Entity.Member;




import com.example.Library.repository.MemberRepository;

//import com.example.Library.repository.MemberWithBookRepository;

//import com.example.Library.repository.MemberWithBookRepository;




@Service

public class MemberServiceImpl implements IMemberService {

@Autowired

private MemberRepository MemberRepository;

@Autowired

//public MemberWithBookRepository memberWithBookRepository;




public MemberServiceImpl(MemberRepository MemberRepository) {

this.MemberRepository = MemberRepository;

}




@Override

public Member getMemberById(int memberId) {

// TODO Auto-generated method stub

return MemberRepository.findById(memberId).orElse(null);

}




@Override

public Member addMember(Member member) {

// TODO Auto-generated method stub

if (member != null) {

return MemberRepository.save(member);

}

return null;

}




@Override

public Member editMember(int memberId, Member member) {




if (member != null) {

Member memberTemp = MemberRepository.findById(memberId).orElse(null);

memberTemp.setMemberAvt(member.getMemberAvt());

memberTemp.setMemberName(member.getMemberName());

memberTemp.setMemberAddress(member.getMemberAddress());

memberTemp.setMemberEmail(member.getMemberEmail());

memberTemp.setMemberPhone(member.getMemberPhone());

memberTemp.setMemberDoB(member.getMemberDoB());




return MemberRepository.save(memberTemp);

}

return null;

}




@Override

public boolean deleteMember(int memberId) {

// TODO Auto-generated method stub

if (memberId >= 1) {

Member memberTemp = MemberRepository.findById(memberId).orElse(null);

if (memberTemp != null) {

MemberRepository.delete(memberTemp);

return true;

}

}

return false;

}




@Override

public List<Member> getMembers() {

// TODO Auto-generated method stub

return MemberRepository.findAll();

}




// @Override

// public List<MemberInfoBookDto> getAllInforMemberWithBook() {

// // TODO Auto-generated method stub

// //throw new UnsupportedOperationException("Unimplemented method

// 'getAllInforMemberWithBook'");

// }




//@Override
//
//public List<Object[]> getAllMemberWithBook() {
////
////return memberWithBookRepository.executeProcMemberWithBook();
//
//}




// @Override

 // public List<Object[]> getAllInforMemberWithBook() {

// return MemberRepository.getAllInforMemberWithBook();

// }

}