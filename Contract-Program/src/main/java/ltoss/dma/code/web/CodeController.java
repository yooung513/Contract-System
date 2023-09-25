package ltoss.dma.code.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.code.domain.Code;
import ltoss.dma.code.service.CodeService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @PostMapping("/code")
    @Transactional
    public ResponseEntity<?> save(@RequestBody Code code) {
        codeService.save(code);
        return ResponseEntity.ok(new MessageResponse(code.getCode() + " 코드 등록 완료"));
    }

    @GetMapping("/code")
    public ResponseEntity<?> findAll(){
        List<Code> code = codeService.findAll();
        return ResponseEntity.ok(code);
    }

    @PutMapping("/code")
    @Transactional
    public ResponseEntity<?> updateCode(@RequestBody Code code) {
        codeService.updateCode(code);
        return ResponseEntity.ok(new MessageResponse(code.getCode() + " 코드 수정 완료"));
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public ResponseEntity<?> deleteByCode(@PathVariable("code") String code) {
        codeService.deleteByCode(code);
        return ResponseEntity.ok(new MessageResponse(code + " 삭제 완료"));
    }
}
