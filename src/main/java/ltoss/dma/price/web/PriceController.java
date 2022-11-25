package ltoss.dma.price.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.repository.JpaPriceDto;
import ltoss.dma.price.service.PriceService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @PostMapping("/price")
    public ResponseEntity<HttpStatus> save(@RequestBody Price price) {
        priceService.save(price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping  ("/price/find")
    public List<Price> findAll(){
        return priceService.findAll();
    }
    @PostMapping("/price/findByDateBetween")
    public List<Price> findByDateBetween(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate) {
        System.out.println("s startDate = " + startDate);
        System.out.println("s endDate = " + endDate);
        return priceService.findByDateBetween(startDate, endDate);

    }
    @PostMapping("/price/Coop") //* 현재 날짜 기준으로 31,30 일 상관없이 30개만 자재(mat_code = mat01,mat02) 가격 가져오기//
    public ResponseEntity<?> findPrice(String mat_code){
        List<JpaPriceDto> price = priceService.findPrice(mat_code);
        return new ResponseEntity<>(price,HttpStatus.OK);
    }
}
