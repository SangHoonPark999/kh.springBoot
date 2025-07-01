package com.kh.common.security;


import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.kh.common.security.domain.CustomUser;
import com.kh.domain.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	// RequestCache는 인증되기 전에 사용자가 접근하려고 했던 요청 정보(URL 등)를 저장
    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {
        CustomUser customUser = (CustomUser) auth.getPrincipal();
        Member member = customUser.getMember();
        log.info("Userid = " + member.getUserId());
        // 이전에 저장된 요청을 가져온다.
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            // 저장된 요청이 없으면 기본 페이지로 이동한다.
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        // 저장된 요청으로 리다이렉트한다.
        String targetUrl = savedRequest.getRedirectUrl();
        response.sendRedirect(targetUrl);
    }

}
