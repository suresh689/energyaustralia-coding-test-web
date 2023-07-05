package com.LMG.API.pozo;

import com.LMG.API.utilities.ReusableMethods;

public class Login extends ReusableMethods {
    private String xForwadedFor;

    public String getxForwadedFor() {
        return xForwadedFor;
    }

    public void setxForwadedFor(String xForwadedFor) {
        this.xForwadedFor = xForwadedFor;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    private String userAgent;




}
