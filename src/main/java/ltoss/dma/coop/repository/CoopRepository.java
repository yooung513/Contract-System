package ltoss.dma.coop.repository;

import ltoss.dma.coop.domain.Coop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoopRepository extends JpaRepository<Coop, Integer> {

    void deleteById(Integer coop_id);
}
