package ltoss.dma.price.repository;

import ltoss.dma.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaPriceRepository extends JpaRepository<Price, Long> {




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


