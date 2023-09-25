package ltoss.dma.price.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
//* Jpql 통해 Dto 를 직접 조회 할 항목//
public interface JpaPriceDto {
//* getPrice , getMatCode, getDate 항목 생성.
     BigDecimal getPrice();

     String getMatCode();

     LocalDate getDate();

}
