package ltoss.dma.dashboard.repository;

import ltoss.dma.dashboard.domain.Dashboard;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer>, JpaSpecificationExecutor<Dashboard> {

    List<Dashboard> findAll(Specification spec);


    @Query(value =  " SELECT MAX(price)              AS q_maxprice" +
                    "       ,MIN(price)              AS q_minprice" +
                    "       ,ROUND(AVG(price), 2)    AS q_avgprice" +
                    "   FROM price AS i" +
                    "  WHERE i.mat_code = ' :mat_code'" +
                    "    ANd date between DATE_FORMAT(NOW()-INTERVAL 90 DAY, '%Y%m%d') AND NOW(); ")
    List<DashboardDto> findPrice(@Param("mat_code") String mat_code);
}
