package ltoss.dma.dashboard.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.dashboard.domain.Dashboard;
import ltoss.dma.dashboard.domain.DashboardSpecification;
import ltoss.dma.dashboard.repository.DashboardDto;
import ltoss.dma.dashboard.repository.DashboardRepository;
import ltoss.dma.dashboard.service.DashboardService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;
    private final DashboardRepository dashboardRepository;

    // 대시보드 정보 전체 조회
    @GetMapping("/dashboard")
    public ResponseEntity<?> findAll(){
        List<Dashboard> dashboard = dashboardService.findAll();
        return ResponseEntity.ok(dashboard);
    }

    // 대시보드 가격정보 조회
    @GetMapping("/dashboard/{mat_code}")
    public ResponseEntity<?> findAll (@PathVariable("mat_code") String mat_code) {

        LocalDate today = LocalDate.now();
        LocalDate quarter = today.minusMonths(3);

        Specification<Dashboard> spec = ((root, query, criteriaBuilder) -> null);
        spec = spec.and(DashboardSpecification.equalMat(mat_code));
        spec = spec.and(DashboardSpecification.betweenDate(quarter, today));

        List<DashboardDto> dashboard = dashboardService.findAll(spec);

        return ResponseEntity.ok(dashboard);
    }

    @PostMapping("/dashboard/{mat_code}")
    @Transactional
    public ResponseEntity<?> findPrice(@PathVariable("mat_code") String mat_code) {
        List<DashboardDto> dashboard = dashboardRepository.findPrice(mat_code);

        dashboardRepository.findPrice(mat_code);

        return ResponseEntity.ok("ok");
    }

}
