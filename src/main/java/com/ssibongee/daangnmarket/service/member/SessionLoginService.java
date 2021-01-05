package com.ssibongee.daangnmarket.service.member;

import com.ssibongee.daangnmarket.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final HttpSession httpSession;
    private final MemberService memberService;
    private static final String MEMBER_ID = "MEMBER_ID";

    @Override
    public void login(long id) {
        httpSession.setAttribute(MEMBER_ID, id);
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(MEMBER_ID);
    }

    @Override
    public Member getLoginMember(long id) {
        Long memberId = (Long) httpSession.getAttribute(MEMBER_ID);

        return memberService.findMemberById(memberId);
    }
}
