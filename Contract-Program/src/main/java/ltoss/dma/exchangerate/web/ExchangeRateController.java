package ltoss.dma.exchangerate.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.exchangerate.domain.ExchangeRate;
import ltoss.dma.exchangerate.service.ExchangeRateService;
import ltoss.dma.login.payload.response.MessageResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin("*")
@Slf4j
@Controller
@AllArgsConstructor
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    @ResponseBody
    @GetMapping("/exchangerate/all")
    public ResponseEntity<?> getAllExchangeRate() {
        List<ExchangeRate> exchangeRateApiList = exchangeRateService.findAll();
        return new ResponseEntity<>(exchangeRateApiList, HttpStatus.OK);
    }

    @GetMapping("/exchangerate")
    public String index(){
        return "index";
    }

    @ResponseBody
    @PostMapping("/exchangerate")
    public ResponseEntity<?> load_save(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        log.debug(date.toString());
        if (exchangeRateService.loadJson(date.toString()) ) {
            return ResponseEntity.ok(new MessageResponse(date.toString()  + "의 환율 정보를 성공적으로 가져왔습니다."));
        }
        return ResponseEntity.ok(new MessageResponse("환율 정보를 가져오지 못했습니다."));
    }

    @ResponseBody
    @GetMapping("/exchangerate/saveall")
    public ResponseEntity<?> load_save_all(){
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow;
        boolean keepGoing;
        while(true) {
            formatedNow = now.format(formatter);

            // 이미 저장된 날짜 데이터면 건너뛴다.
            if (exchangeRateService.isItSaved(formatedNow)) continue;

            log.debug("current={} ", formatedNow);
            keepGoing = exchangeRateService.loadJson(formatedNow);
            now = now.minusDays(1);
            log.debug("after={}", formatedNow);

            if(!keepGoing) {break;}
        }

        return ResponseEntity.ok(new MessageResponse("끝!"));
    }
}