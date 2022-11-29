package ltoss.dma.dashboard.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.dashboard.domain.Dashboard;
import ltoss.dma.dashboard.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    // 대시보드 정보 전체 조회
    @GetMapping("/dashboard")
    public ResponseEntity<?> findAll(){
        List<Dashboard> dashboard = dashboardService.findAll();
        return ResponseEntity.ok(dashboard);
    }

    /**
     * 현재 날짜 기준 7, 30, 90일 전의 가격 데이터를 반환한다.
     * 이다영 2022.11.28
     * @param mat_code
     * @return
     */
    @GetMapping("/dashboard/{mat_code}")
    @Transactional
    public ResponseEntity<?> findPrice(@PathVariable("mat_code") String mat_code) {
        List<Map> price = dashboardService.findPrice(mat_code);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}
