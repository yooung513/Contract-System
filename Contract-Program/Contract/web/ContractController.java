package ltoss.dma.contract.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.domain.ContractSpecification;
import ltoss.dma.contract.payload.UpdateContract;
import ltoss.dma.contract.repository.ContractRepository;
import ltoss.dma.contract.service.ContractService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;
    private final ContractRepository contractRepository;

    // 계약 정보 저장 (등록)
    @PostMapping("/contract")
    @Transactional
    public ResponseEntity<?> save(@RequestBody Contract contract) {
        contractService.save(contract);
        return ResponseEntity.ok(new MessageResponse(contract.getCont_code() + " 계약 등록 완료"));
    }

    // 계약 정보 전체 조회
    @GetMapping("/contract")
    public ResponseEntity<?> findAll(){
        List<Contract> contract = contractService.findAll();
        return ResponseEntity.ok(contract);
    }

    // 계약 정보 업데이트 (수정)
    @PutMapping("/contract/{cont_id}")
    @Transactional
    public ResponseEntity<?> updateContract(@RequestBody UpdateContract updateContract) {
        Optional<Contract> contract = contractRepository.findById(updateContract.getCont_id());
        if (contract.isEmpty()) {
            return new ResponseEntity<>("해당 계약건을 찾을 수 없습니다. 목록을 새로고침 후 다시 시도해주세요", HttpStatus.BAD_REQUEST);
        }

        contractRepository.updateContract(
                updateContract.getCont_id(),
                updateContract.getCont_code(),
                updateContract.getCont_price(),
                updateContract.getCont_quantity(),
                updateContract.getCont_date(),
                updateContract.getCont_enddate(),
                updateContract.getCont_status(),
                updateContract.getMat_code(),
                updateContract.getRemark(),
                updateContract.getUser().getUserId(),
                updateContract.getCoop().getCoop_id(),
                updateContract.getPrice().getPriceId()
        );
        return ResponseEntity.ok(new MessageResponse(
                updateContract.getCont_id() + " 번 계약 정보 수정 완료"));
    }

    // 계약 정보 삭제
    @DeleteMapping("/contract/{cont_id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable("cont_id") Integer cont_id) {
        contractService.deleteById(cont_id);
        return ResponseEntity.ok(new MessageResponse(cont_id + " 번 계약 삭제 완료"));
    }

    // 조건에 따른 계약 정보 조회
    @GetMapping("/contract/spec")
    public ResponseEntity<?> findAll (@RequestParam(required = false) String mat_code,
                                      @RequestParam(required = false) String cont_code,
                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startdate,
                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate enddate,
                                      @RequestParam(required = false) Integer cont_id,
                                      @RequestParam(required = false) Integer user_id,
                                      @RequestParam(required = false) String cont_status,
                                      @RequestParam(required = false) BigDecimal min_price,
                                      @RequestParam(required = false) BigDecimal max_price) {

        Specification<Contract> spec = ((root, query, criteriaBuilder) -> null);

        if (mat_code != null)
            spec = spec.and(ContractSpecification.equalMat(mat_code));
        if (cont_code != null)
            spec = spec.and(ContractSpecification.likeContName(cont_code));
        if (startdate != null && enddate != null)
            spec = spec.and(ContractSpecification.betweenDate(startdate, enddate));
        if (cont_id != null)
            spec = spec.and(ContractSpecification.equalContId(cont_id));
        if (user_id != null)
            spec = spec.and(ContractSpecification.equalUserId(user_id));
        if (cont_status != null)
            spec = spec.and(ContractSpecification.equalContStatus(cont_status));
        if (min_price != null)
            spec = spec.and(ContractSpecification.greaterPrice(min_price));
        if (max_price != null)
            spec = spec.and(ContractSpecification.lessPrice(max_price));

        List<Contract> contract = contractService.findAll(spec);
        return ResponseEntity.ok(contract);
    }
}
