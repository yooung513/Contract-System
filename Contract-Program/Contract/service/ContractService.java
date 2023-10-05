package ltoss.dma.contract.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.repository.ContractRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    /**
     * 계약 정보 저장
     * @param contract
     */
    public void save(Contract contract) {
        BigDecimal percent = new BigDecimal("1.1");
        contract.setAlarmprice(contract.getCont_price().multiply(percent));
        contractRepository.save(contract); }

    /**
     * 계약 정보 전체 조회
     * @return
     */
    public List<Contract> findAll() { return contractRepository.findAll(); }

    /**
     * 아이디에 따른 계약 정보 삭제
     * @param cont_id
     */
    public void deleteById(Integer cont_id) { contractRepository.deleteById(cont_id); }

    /**
     * 조건에 따른 계약 정보 조회
     * @param spec
     * @return
     */
    public List<Contract> findAll(Specification spec) {
        return contractRepository.findAll(spec);
    }
}
