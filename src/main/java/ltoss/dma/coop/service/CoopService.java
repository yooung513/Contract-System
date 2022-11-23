package ltoss.dma.coop.service;

import lombok.AllArgsConstructor;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.coop.repository.JpaCoopRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CoopService {

    private final JpaCoopRepository jpaCoopRepository;

    public List<Coop> findAll(){
        return  jpaCoopRepository.findAll();
    }
    public void insert(Coop coop){
        jpaCoopRepository.save(coop);

    }
    public void update(Coop coop){
        jpaCoopRepository.save(coop);
    }
    public void deleteCoop(Coop coop){
        jpaCoopRepository.deleteById(coop.getCoop_id());

    }

}