package ltoss.dma.coop.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.code.domain.Code;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.coop.service.CoopService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class CoopController {

    private final CoopService coopService;

    @PostMapping("/coop")
    @Transactional
    public ResponseEntity<?> save(@RequestBody Coop coop) {
        coopService.save(coop);
        return ResponseEntity.ok(new MessageResponse(
                coop.getCoop_name() + " 협력사 등록 완료"));
    }

    @GetMapping("/coop")
    public ResponseEntity<?> findAll(){
        List<Coop> coop = coopService.findAll();
        return ResponseEntity.ok(coop);
    }

    @PatchMapping("/coop")
    @Transactional
    public ResponseEntity<?> updateCoop(@RequestBody Coop coop) {
        coopService.updateCoop(coop);
        return ResponseEntity.ok(new MessageResponse(
                coop.getCoop_name() + " 협력사 정보 수정 완료"));
    }

    @DeleteMapping("/coop/{coop_id}")
    @Transactional
    public ResponseEntity<?> deleteById(@PathVariable("coop_id") Integer coop_id) {
        coopService.deleteById(coop_id);
        return ResponseEntity.ok
                (new MessageResponse(coop_id + " 번 협력사 삭제 완료"));
    }
}
