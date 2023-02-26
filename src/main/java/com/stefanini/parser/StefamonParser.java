package com.stefanini.parser;

import com.stefanini.dto.StefamonDTO;
import com.stefanini.entity.Stefamon;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StefamonParser {

    public static Stefamon DtotoEntity(StefamonDTO dto) {
        Stefamon stefamon = new Stefamon();
        return stefamon;
    }

}
