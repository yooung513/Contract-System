package ltoss.dma.price.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ltoss.dma.price.domain.Price;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Repository
@Transactional
public class JpaPriceRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public JpaPriceRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public Price save(Price price) {
        em.persist(price);
        return price;
    }
}

//    try {
//
//        public Price save(Price price){
//            em.persist(price);
//            return price;
//    } catch (Exception e) {
//            return "X";
//        }
//
//    }


