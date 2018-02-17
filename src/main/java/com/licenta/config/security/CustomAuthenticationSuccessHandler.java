package com.licenta.config.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        handle(httpServletRequest, httpServletResponse, authentication);
        clearAuthenticationAttributes(httpServletRequest);
    }

    private void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                        Authentication authentication) throws IOException {
        String targetUrlToRedirect = determineTargetUrl(authentication);
        if (httpServletResponse.isCommitted()) {
            logger.debug("Response has already been committed. nable to redirect to" + targetUrlToRedirect);
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, targetUrlToRedirect);
    }

    public String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        boolean isDoctor = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else {
                isDoctor = true;
                break;
            }
        }

        if (isUser) {
            return "userProfile";
        } else if (isAdmin) {
            return "adminPanel";
        } else if (isDoctor) {
            return "doctorProfile";
        } else {
            throw new IllegalStateException();
        }
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

}
