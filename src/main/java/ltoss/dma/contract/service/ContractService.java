<<<<<<< HEAD
package ltoss.dma.contract.service;public class ContractService {
}
=======
package ltoss.dma.contract.service;

import lombok.AllArgsConstructor;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.repository.ContractRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void save(Contract contract) {
        BigDecimal percent = new BigDecimal("1.1");
        contract.setAlarmprice(contract.getCont_price().multiply(percent));
        contractRepository.save(contract);
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public void update(Contract contract){
        BigDecimal percent = new BigDecimal("1.1");
        contract.setAlarmprice(contract.getCont_price().multiply(percent));
        contractRepository.save(contract);
    }

    public void delete(Contract contract){
        contractRepository.deleteById(contract.getCont_id());
    }

    public List<Contract> findAll(Specification spec) {
        return contractRepository.findAll(spec);
    }
}
>>>>>>> origin/main
