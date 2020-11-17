package edu.tarleton.restorder;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ItemsService {

    @PersistenceContext
    private EntityManager em;

    public void insert(String name) {
        Item item = new Item();
        item.setName(name);
        em.persist(item);
    }
    
    public Item selectById(Long id) {
        return em.find(Item.class, id);
    }
    
    public Collection<Item> selectAll() {
        TypedQuery<Item> q = em.createNamedQuery("Item.selectAll", Item.class);
        return q.getResultList();
    }
}
