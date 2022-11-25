package ltoss.dma.price.repository;

import ltoss.dma.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //* 현재 날짜 기준으로 31,30 일 상관없이 30개만 자재(mat_code = mat01,mat02) 가격,날짜,자재코드 가져오기//
    //* Jpql 문으로//
    @Query(nativeQuery = true, value = "select p.price, p.mat_code as matCode, p.date from price AS p WHERE p.mat_code = :mat_code ORDER BY p.date DESC limit 30")
    List<JpaPriceDto> findByPrice(@Param("mat_code") String mat_code); //*파라매터 바인딩 mat_code //

}



