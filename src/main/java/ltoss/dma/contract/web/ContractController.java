package ltoss.dma.contract.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.domain.ContractSpecification;
import ltoss.dma.contract.service.ContractService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping("/contract")
    public ResponseEntity<HttpStatus> save (@RequestBody Contract contract){
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/contract")
    public List<Contract> findAll(){
        return contractService.findAll();
    }

    @PutMapping("/contract")
    public ResponseEntity<HttpStatus> update (@RequestBody Contract contract) {
        contractService.update(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contract")
    public ResponseEntity<HttpStatus> delete (@RequestBody Contract contract) {
        contractService.delete(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/contract/spec")
    public List<Contract> findAll (@RequestParam(required = false) String mat_code,
                                   @RequestParam(required = false) String cont_code,
                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startdate,
                                   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate enddate,
                                   @RequestParam(required = false) Integer cont_id,
                                   @RequestParam(required = false) Integer user_id,
                                   @RequestParam(required = false) String cont_status,
                                   @RequestParam(required = false) BigDecimal min_price,
                                   @RequestParam(required = false) BigDecimal max_price) {

//        Specification<Contract> spec = Specification.where(ContractSpecification.equalMat(mat_code));
        Specification<Contract> spec = (root, query, criteriaBuilder) -> null;

        if (mat_code != null) {
            spec = spec.and(ContractSpecification.equalMat(mat_code));
        }
        if (cont_code != null) {
            spec = spec.and(ContractSpecification.likeContName(cont_code));
        }
        if (startdate != null && enddate != null) {
            spec = spec.and(ContractSpecification.betweenDate(startdate, enddate));
        }
        if (cont_id != null) {
            spec = spec.and(ContractSpecification.equalContId(cont_id));
        }
        if (user_id != null) {
            spec = spec.and(ContractSpecification.equalUserId(user_id));
        }
        if (cont_status != null) {
            spec = spec.and(ContractSpecification.equalContStatus(cont_status));
        }
        if (min_price != null) {
            spec = spec.and(ContractSpecification.greaterPrice(min_price));
        }
        if (max_price != null) {
            spec = spec.and(ContractSpecification.lessPrice(max_price));
        }

        return contractService.findAll(spec);
    }
}