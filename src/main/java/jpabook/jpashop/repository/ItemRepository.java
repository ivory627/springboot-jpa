package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {
            em.persist(item);
        }else {
            /*
                병합 : 준영속 상태의 엔티티를 영속 상태로 변경
                - 영속엔티티의 모든 필드를 준영속 엔티티 값으로 교체함
                - 값이 없으면 null 값으로 변경되는 위험이 있음
             */
            em.merge(item);
        }
    }



    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
