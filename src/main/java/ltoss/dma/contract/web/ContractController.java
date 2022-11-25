package ltoss.dma.contract.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.contract.payload.UpdateRequest;
import ltoss.dma.contract.repository.ContractRepository;
import ltoss.dma.contract.service.ContractService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    private final ContractRepository contractRepository;

    @PostMapping("/contract")
    @Transactional
    public ResponseEntity<?> save(@RequestBody Contract contract) {
        contractService.save(contract);
        return ResponseEntity.ok(new MessageResponse(
                contract.getCont_code() + " 계약 등록 완료"));
    }

    @GetMapping("/contract")
    public ResponseEntity<?> findAll(){
        List<Contract> contract = contractService.findAll();
        return ResponseEntity.ok(contract);
    }

    @PatchMapping("/contract/{cont_id}")
    @Transactional
    public ResponseEntity<?> updateContract(@RequestBody UpdateRequest updateRequest) {
        Optional<Contract> contract = contractRepository.findById(updateRequest.getCont_id());
        if (contract.isEmpty()) {
            return new ResponseEntity<>("해당 계약건을 찾을 수 없습니다. 목록을 새로고침 후 다시 시도해주세요", HttpStatus.BAD_REQUEST);
        }

        contractRepository.updateContract(
                updateRequest.getCont_id(),
                updateRequest.getCont_code(),
                updateRequest.getCont_price(),
                updateRequest.getCont_quantity(),
                updateRequest.getCont_date(),
                updateRequest.getCont_enddate(),
                updateRequest.getCont_status(),
                updateRequest.getMat_code(),
                updateRequest.getRemark(),
                updateRequest.getUser_id(),
                updateRequest.getCoop_id(),
                updateRequest.getPrice_id()
        );
        return ResponseEntity.ok(new MessageResponse(
                updateRequest.getCont_id() + " 번 계약 정보 수정 완료"));
    }


    @DeleteMapping("/contract/{cont_id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable("cont_id") Integer cont_id) {
        contractService.deleteById(cont_id);
        return ResponseEntity.ok(new MessageResponse(
                cont_id + " 번 계약 삭제 완료"));
    }
}
