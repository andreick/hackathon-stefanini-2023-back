package com.stefanini.provider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;

@ApplicationScoped
public class PersistenceProvider {

    @Produces
    PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();
}
