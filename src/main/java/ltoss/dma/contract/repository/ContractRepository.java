package ltoss.dma.contract.repository;

import ltoss.dma.contract.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Modifying
    @Query(value = "update contract ui" +
            "   set ui.cont_code     = :cont_code" +
            "     , ui.cont_price    = :cont_price" +
            "     , ui.cont_quantity = :cont_quantity" +
            "     , ui.cont_date     = :cont_date" +
            "     , ui.cont_enddate  = :cont_enddate" +
            "     , ui.cont_status   = :cont_status" +
            "     , ui.mat_code      = :mat_code" +
            "     , ui.remark        = :remark" +
            "     , ui.user_id       = :user_id" +
            "     , ui.coop_id       = :coop_id" +
            "     , ui.price_id      = :price_id" +
            " where ui.cont_id = :cont_id", nativeQuery = true)
    int updateContract(
            @Param("cont_id") Integer cont_id,
            @Param("cont_code") String cont_code,
            @Param("cont_price") BigDecimal cont_price,
            @Param("cont_quantity") BigDecimal cont_quantity,
            @Param("cont_date") LocalDate cont_date,
            @Param("cont_enddate") LocalDate cont_enddate,
            @Param("cont_status") String cont_status,
            @Param("mat_code") String mat_code,
            @Param("remark") String remark,
            @Param("user_id") Long user_id,
            @Param("coop_id") Integer coop_id,
            @Param("price_id") Integer price_id

    );

    void deleteById(Integer cont_id);
}
