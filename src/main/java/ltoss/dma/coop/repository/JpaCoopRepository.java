package ltoss.dma.coop.repository;

import ltoss.dma.coop.domain.Coop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCoopRepository extends JpaRepository<Coop, Integer> {

}