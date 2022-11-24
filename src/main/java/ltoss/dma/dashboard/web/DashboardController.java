package ltoss.dma.dashboard.web;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.dashboard.repository.DashboardDto;
import ltoss.dma.dashboard.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
public class DashboardController {

    DashboardService dashboardService;
    DashboardDto dashboardDto;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboardInfo() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/dashboard/{mat_code}")
    @Transactional
    public ResponseEntity<?> find(@PathVariable("mat_code") String mat_code) {
        DashboardDto matCode = dashboardService.findByMatCode(mat_code);
        return ResponseEntity.ok(matCode);
    }
}
