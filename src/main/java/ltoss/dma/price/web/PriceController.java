package ltoss.dma.price.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.service.PriceService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @PostMapping("/price")
    public String save(@RequestBody Price price) {
        priceService.save(price);
        return "ok";
    }


}
