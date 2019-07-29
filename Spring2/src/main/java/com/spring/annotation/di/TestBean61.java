package com.spring.annotation.di;

import javax.persistence.*;
//@Component
public class TestBean61 {
    
    @PersistenceContext(unitName = "entityManagerFactory", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
    
    @PersistenceUnit(unitName = "entityManagerFactory")
    private EntityManagerFactory entityManagerFactory;
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
