

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

@Service
@Transactional
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;

    /**
     * 계약 정보 저장
     * 이다영 2022-11-24
     * @param contract
     */
    public void save(Contract contract) {
        BigDecimal percent = new BigDecimal("1.1");
        contract.setAlarmprice(contract.getCont_price().multiply(percent));
        contractRepository.save(contract);
    }

    /**
     * 계약 정보 전체 조회
     * 이다영 2022-11-24
     * @return
     */
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

//    public void update(Contract contract){
//        BigDecimal percent = new BigDecimal("1.1");
//        contract.setAlarmprice(contract.getCont_price().multiply(percent));
//        contractRepository.save(contract);
//    }

    /**
     * 계약 Id에 따라 계약 정보 삭제
     * 이다영 2022-11-24
     * @param cont_id
     */
    public void deleteById(Integer cont_id){
        contractRepository.deleteById(cont_id);
    }

    /**
     * 조건에 따른 계약 정보 조회
     * 이다영 2022-11-24
     * @param spec
     * @return
     */
    public List<Contract> findAll(Specification spec) {
        return contractRepository.findAll(spec);
    }
}
