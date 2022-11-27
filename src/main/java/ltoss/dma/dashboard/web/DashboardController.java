package ltoss.dma.dashboard.web;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.dashboard.repository.DashboardDto;
import ltoss.dma.dashboard.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        // 오늘
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);

        Calendar cal = Calendar.getInstance();
        // 1주일전 (-7일)
        cal.add(Calendar.DATE, -7);
        String week = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        // 한 달 전 (-30일)
        cal.add(Calendar.DATE, -30);
        String month = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        // 세 달 전 (-90일)
        cal.add(Calendar.DATE, -90);
        String months = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());


//        DashboardDto matCode = dashboardService.findByMatCode(mat_code);
        return ResponseEntity.ok("ok");
    }
}
