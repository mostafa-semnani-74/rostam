package ir.mostafa.semnani.rostambackend.common.security.jwt;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
