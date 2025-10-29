package com.ssg.membertest.controller;

import com.ssg.membertest.DTO.MemberDTO;
import com.ssg.membertest.Service.MemberService2;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService2 memberService2;

    @GetMapping("/memberList")
    public void memberlist(Model model) {
        log.info("전체 명단 출력....");
        model.addAttribute("memberList", memberService2.memberList());
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("회원 등록 폼 실행 ....");
    }

    @PostMapping("/register")
    public String registerPOST(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        log.info("POST /member/register ... (회원 등록 처리)");
        log.info("전달받은 DTO: " + memberDTO);
        memberService2.registerMember(memberDTO);

        redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");

        return "redirect:/member/memberList";
    }


}
