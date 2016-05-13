package com.sai.one.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by shravan on 4/24/2016.
 */
public class JpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
