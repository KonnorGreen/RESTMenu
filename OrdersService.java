package edu.tarleton.restorder;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class OrdersService {

    @PersistenceContext
    private EntityManager em;

    public void insert(Orders order) {
        em.persist(order);
    }

    public void removeOrder(Integer id) {
        Orders order = em.find(Orders.class, id);
        em.remove(order);
    }

    public void selectId(Integer id) {
        Orders order = em.find(Orders.class, id);
        System.out.println("ID: " + id);
        System.out.println("Order: " + order);
    }

    public Collection<Orders> selectAll() {
        TypedQuery<Orders> q = em.createNamedQuery("Orders.selectAll", Orders.class);
        return q.getResultList();
    }
}
