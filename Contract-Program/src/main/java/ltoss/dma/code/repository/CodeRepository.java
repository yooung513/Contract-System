package ltoss.dma.code.repository;

import ltoss.dma.code.domain.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CodeRepository extends JpaRepository<Code, String> {
    void deleteByCode(String code);

    /**
     * mat_code 컬럼에 해당하는 모든 Code 객체를 반환한다.
     * @param matCodes
     * @return
     */
    @Query(nativeQuery = true, value = "select * from code_master c where c.code in (:matCodes)")
    Set<Code> findDescriptionByIds(@Param("matCodes") Set<String> matCodes);
}
