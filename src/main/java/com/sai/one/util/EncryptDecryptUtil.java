package com.sai.one.util;


import com.sai.one.constants.PropertyConstants;
import com.sai.one.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Created by shravan
 */

@Component
public class EncryptDecryptUtil {

    private static final Logger LOGGER = Logger.getLogger(EncryptDecryptUtil.class.getName());
    @Autowired
    private CommonUtil commonUtil;
    private final Mac hmac;

    {
        try {
            hmac = Mac.getInstance(PropertyConstants.EncryptDecrypt.HMAC_ALGORITHM);
            hmac.init(KeyGenerator.getInstance(PropertyConstants.EncryptDecrypt.HMAC_ALGORITHM).generateKey());
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
        }
    }

    public UserAuth parseUserFromToken(String token) {
        final String[] parts = token.split(Pattern.quote(PropertyConstants.EncryptDecrypt.SEPARATOR));
        if (parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0) {
            try {
                final byte[] userBytes = fromBase64(parts[0]);
                final byte[] hash = fromBase64(parts[1]);

                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
                if (validHash) {
                    final UserAuth user = commonUtil.fromJSONtoObj(userBytes, UserAuth.class);
                    return user;
                }
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.SEVERE, "ERROR in parseUserFromToken for auth:" + token);
            }
        }
        return null;
    }

    public String createTokenForUser(UserAuth user) {
        byte[] userBytes = commonUtil.objToJson(user);
        byte[] hash = createHmac(userBytes);
        final StringBuilder sb = new StringBuilder(200);
        sb.append(toBase64(userBytes));
        sb.append(PropertyConstants.EncryptDecrypt.SEPARATOR);
        sb.append(toBase64(hash));
        return sb.toString();
    }

    private String toBase64(byte[] content) {
        return DatatypeConverter.printBase64Binary(content);
    }

    private byte[] fromBase64(String content) {
        return DatatypeConverter.parseBase64Binary(content);
    }

    // synchronized to guard internal hmac object
    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }
}
