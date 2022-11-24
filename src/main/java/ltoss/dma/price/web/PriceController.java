package ltoss.dma.price.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.service.PriceService;
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
    @PostMapping("price/findByDateBetween")
    public List<Price> findByDateBetween(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate) {
        System.out.println("s startDate = " + startDate);
        System.out.println("s endDate = " + endDate);
        return priceService.findByDateBetween(startDate, endDate);

    }
}
