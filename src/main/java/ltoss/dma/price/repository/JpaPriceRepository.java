package ltoss.dma.price.repository;

import ltoss.dma.price.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface JpaPriceRepository extends JpaRepository<Price, Long> {

    /**
     * 시작일, 종료일에 해당하는 가격 데이터를 조회한다.
     * @param sDate
     * @param eDate
     * @return List<Price>
     */
    List<Price> findByDateBetween(LocalDate sDate, LocalDate eDate);


    /** 현재 날짜 기준으로 31,30 일 상관없이 30개만 자재(mat_code = mat01,mat02) 가격,날짜,자재코드 가져오기
     * Jpql
     * 박남길 2022.11.25(최초), 이기수 2022.11.27(수정)
     * @param matCode
     * @return
     */
    @Query(nativeQuery = true,
            value = "select p.price" +
                    "     , p.mat_code as matCode" +
                    "     , p.date " +
                    "  from price AS p" +
                    " WHERE p.mat_code = :matCode" +
                    " ORDER BY p.date DESC limit 30")
    List<JpaPriceDto> findByPrice(@Param("matCode") String matCode); //*파라미터 바인딩 mat_code //

}



