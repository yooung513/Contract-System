package ltoss.dma.coop.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.code.domain.Code;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.coop.repository.CoopRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CoopService {

    private final CoopRepository coopRepository;

    public void save(Coop coop) { coopRepository.save(coop); }

    public List<Coop> findAll() { return coopRepository.findAll(); }

    public void updateCoop(Coop coop) { coopRepository.save(coop); }

    public void deleteById(Integer coop_id) { coopRepository.deleteById(coop_id); }


}
