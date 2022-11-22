package ltoss.dma.coop.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.coop.repository.JpaCoopRepository;
import ltoss.dma.coop.service.CoopService;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class CoopController {

    private final CoopService coopService;

    @PostMapping("/coop/find")
    public List<Coop> findAll(){
        return  coopService.findAll();
    }

    @PostMapping("/coop/insert")
    public ResponseEntity<HttpStatus> save (@RequestBody Coop Coops){
        coopService.insert(Coops);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/coop/insert/update")
    public String updateCoopInfo(@RequestBody Coop coops){
        coopService.update(coops);
        return "ok";
    }
    @DeleteMapping("/coop")
    public ResponseEntity<HttpStatus> deleteCoopInfo(@RequestBody Coop coops){
        coopService.deleteCoop(coops);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}