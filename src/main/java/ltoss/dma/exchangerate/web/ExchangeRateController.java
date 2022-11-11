package ltoss.dma.exchangerate.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.exchangerate.service.ExchangeRateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
@AllArgsConstructor
public class ExchangeRateController {

    private ExchangeRateService exchangeRateService;

    @GetMapping("/exchangerate")
    public String index(){
        return "index";
    }

    @PostMapping("/exchangerate")
    public String load_save(@RequestParam("date") String date){
        exchangeRateService.loadJson(date);
        return "redirect:/exchangerate";
    }

    @GetMapping("/exchangerate-all")
    public String load_save_all(){
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatedNow;
        boolean keepGoing;
        while(true) {
            formatedNow = now.format(formatter);
            log.debug("current={} ", formatedNow);
            keepGoing = exchangeRateService.loadJson(formatedNow);
            now = now.minusDays(1);
            log.debug("after={}", formatedNow);

            if(!keepGoing) {break;}
        }

        return "redirect:/exchangerate";
    }
}