package com.AracStickerSistemi.Model;


import com.AracStickerSistemi.Controller.ProfileController;
import com.AracStickerSistemi.Controller.WelcomeController;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String id = servletRequest.getParameter("ID");
        String pass = servletRequest.getParameter("PASS");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse  res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();

        if (ProfileController.userProfile.isHasUser()) {

            UserProfile userProfile = new UserProfile();
            userProfile.setId(id);
            userProfile.setPassword(pass);

            boolean sonuc = false;

            try {
                if (id != null && pass != null && id !=  "" && pass != "") {
                    sonuc = WelcomeController.dataBaseController.loginControl(userProfile);
                }
                else {
                    sonuc = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(sonuc);
            System.out.println(id);
            System.out.println(pass);
            if (!sonuc) {
                if (url.contains("Profile")){
                    res.sendRedirect(req.getContextPath() + "/LoginPanel");
                } else {
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            } else {
                ProfileController.userProfile.setHasUser(false);
                if(url.endsWith("/")) {
                    res.sendRedirect(req.getContextPath() + "/Profile");
                } else if (url.contains("/StickerBasvuru")) {
                    res.sendRedirect(req.getContextPath() + "/Profile");
                } else if (url.contains("/LoginPanel")) {
                    System.out.println("cikis yapıldı");
                    ProfileController.userProfile.setHasUser(true);
                    res.sendRedirect(req.getContextPath() + "/LoginPanel");
                } else {
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }
        } else {
            if(url.endsWith("/")) {
                res.sendRedirect(req.getContextPath() + "/Profile");
            } else if (url.contains("/StickerBasvuru")) {
                res.sendRedirect(req.getContextPath() + "/Profile");
            } else if (url.contains("/LoginPanel")) {
                System.out.println("cikis yapıldı");
                ProfileController.userProfile.setHasUser(true);
                res.setHeader("Cache-Control","no-cache");
                res.setHeader("Cache-Control","no-store");
                res.setHeader("Pragma","no-cache");
                res.setDateHeader ("Expires", 0);
                res.sendRedirect(req.getContextPath() + "/LoginPanel");
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
