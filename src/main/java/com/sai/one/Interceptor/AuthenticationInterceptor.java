package com.sai.one.Interceptor;

import com.sai.one.util.EncryptDecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by shravan
 */
public class AuthenticationInterceptor  extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationInterceptor.class.getName());

    @Autowired
    private EncryptDecryptUtil encryptDecryptUtil;

   // @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String authToken = request.getHeader(MobileServiceConstants.X_AKOSHA_ACCESS_TOKEN);
//        if (!StringUtils.isBlank(akoshaAccessCode)) {
//
//            try {
//                V3UserAuth userAuth = tokenHandler.parseV3UserFromToken(akoshaAccessCode);
//                LOGGER.debug("V3 user auth mobile: " + userAuth.getMobile() + " & id: " + userAuth.getId());
//
//                if (userAuth != null && userAuth.getId() > 0) {
//                    String authToken = getAccessCodes(userAuth.getId());
//                    if (authToken.equals(akoshaAccessCode)) {
//                        LOGGER.info("PING:::" + userAuth.getId() + ":::PING:::INTERCEPTOR");
//                        //LOGGER.debug("Authentication successful!");
//                        request.setAttribute(MobileServiceConstants.USER_AUTH, userAuth);
//                        return true;
//                    }
//                }
//            } catch (Exception e) {
//                LOGGER.error("", e);
//            }
//        }
//
//        LOGGER.info("401 unauthorized for token: " + akoshaAccessCode);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        return false;
//    }
}
