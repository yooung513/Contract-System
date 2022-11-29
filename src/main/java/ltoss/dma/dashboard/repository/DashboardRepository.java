package ltoss.dma.dashboard.repository;

import ltoss.dma.dashboard.domain.Dashboard;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer>{

    List<Dashboard> findAll(Specification spec);

    /**
     * 현재 날짜 기준 7, 30, 90일 전의 가격 데이터를 반환한다.
     * 이다영 2022.11.28
     * @param mat_code
     * @return
     */
    @Query(nativeQuery = true,
            value = " SELECT MAX(a.price)           AS quartermaxprice " +
                    "       ,MIN(a.price)           AS quarterminprice " +
                    "       ,ROUND(AVG(a.price), 2) AS quarteravgprice " +
                    "       ,MAX(b.price)           AS monthmaxprice " +
                    "       ,MIN(b.price)           AS monthminprice " +
                    "       ,ROUND(AVG(b.price), 2) AS monthavgprice " +
                    "       ,MAX(c.price)           AS weekmaxprice " +
                    "       ,MIN(c.price)           AS weekminprice " +
                    "       ,ROUND(AVG(c.price), 2) AS weekavgprice " +
                    "   FROM price AS a     LEFT JOIN (SELECT *  " +
                    "                                    FROM price " +
                    "                                   WHERE mat_code = :mat_code " +
                    "                                     AND date BETWEEN DATE_FORMAT(NOW()-INTERVAL 30 DAY, '%Y%m%d') AND NOW()) AS b " +
                    "                              ON a.price_id = b.price_id " +
                    "                       LEFT JOIN (SELECT * " +
                    "                                    FROM price " +
                    "                                   WHERE mat_code = :mat_code " +
                    "                                     AND date BETWEEN DATE_FORMAT(NOW()-INTERVAL 7 DAY, '%Y%m%d') AND NOW()) AS c " +
                    "                              ON b.price_id = c.price_id " +
                    "  WHERE a.mat_code = :mat_code " +
                    "    AND a.date BETWEEN DATE_FORMAT(NOW()-INTERVAL 30 DAY, '%Y%m%d') AND NOW(); "
    )
    List<JpaDashboardDto> findByPrice(@Param("mat_code") String mat_code);
}
