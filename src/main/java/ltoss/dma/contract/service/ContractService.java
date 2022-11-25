package ltoss.dma.contract.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.payload.UpdateRequest;
import ltoss.dma.contract.repository.ContractRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    public void save(Contract contract) { contractRepository.save(contract); }

    public List<Contract> findAll() { return contractRepository.findAll(); }

    public Optional<Contract> findById(Integer cont_id) { return contractRepository.findById(cont_id); }

//    public void updateContract(UpdateRequest updateRequest) {
//        contractRepository.updateContract(updateRequest); }

    public void deleteById(Integer cont_id) { contractRepository.deleteById(cont_id); }
}
