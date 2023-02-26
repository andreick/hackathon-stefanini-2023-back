package com.stefanini.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.Base64;

@ApplicationScoped
public class CriptografiaService {

    public String criptografar(String src) {
        return Base64.getEncoder().encodeToString(src.getBytes());
    }

    public String decriptografar(String encodedString) {
        var bytes = Base64.getDecoder().decode(encodedString);
        return new String(bytes);
    }
}
