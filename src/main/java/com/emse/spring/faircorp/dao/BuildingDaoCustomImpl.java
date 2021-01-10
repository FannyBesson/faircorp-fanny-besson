package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Building> findByBuildingName(String name) {
        String jpql = "select r from Room r where r.name = :name";
        return em.createQuery(jpql, Building.class)
                .setParameter("name", name)
                .getResultList();
    }
}
