package ltoss.dma.coop.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.coop.repository.JpaCoopRepository;
import ltoss.dma.coop.service.CoopService;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CoopController {

    private final CoopService coopService;

    @GetMapping("/coop")
    public List<Coop> findAll(){
        return  coopService.findAll();
    }

    @PostMapping("/coop")
    public ResponseEntity<?> save (@RequestBody Coop coop){
        coopService.save(coop);
        return ResponseEntity.ok(new MessageResponse(
                coop.getCoop_name() + " 협력사 등록 완료"
        ));
    }

    @PutMapping("/coop")
    public ResponseEntity<?> update (@RequestBody Coop coop){
        coopService.save(coop);
        return ResponseEntity.ok(new MessageResponse(
                coop.getCoop_name() + " 협력사 수정 완료"
        ));
    }
    @DeleteMapping("/coop/{coop_id}")
    public ResponseEntity<?> deleteById (@PathVariable("coop_id") Integer coop_id){
        coopService.deleteById(coop_id);
        return ResponseEntity.ok(new MessageResponse(
                coop_id + " 번 협력사 삭제 완료"
        ));
    }
}