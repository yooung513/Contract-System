package ltoss.dma.price.repository;

import ltoss.dma.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


public interface JpaPriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByDateBetween(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate sDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate eDate);

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


