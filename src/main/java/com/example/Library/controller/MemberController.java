package com.example.Library.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;




import com.example.Library.Entity.Member;

import com.example.Library.service.IMemberService;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;




// import lombok.Data;




@RestController

@RequestMapping("/member")

public class MemberController {

@Autowired

private IMemberService iMemberService;




@GetMapping("/")

public String test() {

    return "hello guys";

}




//

@PostMapping("/add")

public Member addMember(@RequestBody Member member) {

return iMemberService.addMember(member);

}




@DeleteMapping("/delete/{id}")

public boolean deleteMember(@PathVariable("id") int id) {

return iMemberService.deleteMember(id);

}




@PutMapping(value = "update/{id}")

public Member editMember(@PathVariable("id") int id, @RequestBody Member member) {

// TODO: process PUT request

return iMemberService.editMember(id, member);

}




@GetMapping("/allMember")

public List<Member> getAllMember() {

return iMemberService.getMembers();

}




@GetMapping("/getMemberById/{id}")

public Member getMemberById(@PathVariable("id") int id) {

return iMemberService.getMemberById(id);

}




// get infor all members with book relationship

//@GetMapping("/allMemberToBook")
//
//public List<Object[]> getAllMemberToBook() {
//
//return iMemberService.getAllMemberWithBook();
//
//}

}