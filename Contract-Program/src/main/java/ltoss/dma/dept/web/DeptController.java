package ltoss.dma.dept.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.code.domain.Code;
import ltoss.dma.code.service.CodeService;
import ltoss.dma.dept.domain.Dept;
import ltoss.dma.dept.service.DeptService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class DeptController {

    private final DeptService deptService;

    @PostMapping("/dept")
    @Transactional
    public ResponseEntity<?> save(@RequestBody Dept dept) {
        deptService.save(dept);
        return ResponseEntity.ok(new MessageResponse(dept.getDeptCode() + " 부서 등록 완료"));
    }

    @GetMapping("/dept")
    public ResponseEntity<?> findAll(){
        List<Dept> dept = deptService.findAll();
        return ResponseEntity.ok(dept);
    }

    @PutMapping("/dept")
    @Transactional
    public ResponseEntity<?> updateCode(@RequestBody Dept dept) {
        deptService.save(dept);
        return ResponseEntity.ok(new MessageResponse(dept.getDeptCode() + " 부서 수정 완료"));
    }

    @DeleteMapping("/dept/{dept_code}")
    @Transactional
    public ResponseEntity<?> deleteByCode(@PathVariable("dept_code") String dept_code) {
        deptService.deleteByDeptCode(dept_code);
        return ResponseEntity.ok(new MessageResponse(dept_code + " 부서 삭제 완료"));
    }
}
