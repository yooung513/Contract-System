package ltoss.dma.code.repository;

import ltoss.dma.code.domain.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, String> {
    void deleteByCode(String code);
}
