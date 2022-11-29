package ltoss.dma.price.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.repository.PeriodicalPrice;
import ltoss.dma.price.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    /**
     * 가격 정보 하나를 저장한다.
     * 이기수 2022.11.27(수정)
     * @param price
     * @return ResponseEntity
     */
    @PostMapping("/price/save")
    public ResponseEntity<?> save(@RequestBody Price price) {
        priceService.save(price);
        return ResponseEntity.ok(new MessageResponse("가격 데이터를 성공적으로 저장했습니다."));
    }

    /**
     * 모든 가격 정보를 가져온다.
     * @return ResponseEntity
     */
    @GetMapping  ("/price/all")
    public ResponseEntity<?> findAll(){
        List<Price> prices = priceService.findAll();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    /**
     * 시작일, 종료일에 해당하는 가격 데이터를 반환한다.
     * 박남길, 이다영 2022.11.25, 이기수 2022.11.27(수정)
     * @param periodicalPrice
     * @return ResponseEntity
     */
    @PostMapping("/price/findByDateBetween")
    public ResponseEntity<?> findByDateBetween(@RequestBody PeriodicalPrice periodicalPrice) {
        List<Price> prices = priceService.findByDateBetween(periodicalPrice.getStartDate(), periodicalPrice.getEndDate());
        return new ResponseEntity<>(prices, HttpStatus.OK);

    }

    /** 현재 날짜 기준 최근 30일간의 자재(mat_code = mat01,mat02) 가격 데이터를 반환한다.
     * 박남길 2022.11.25(최초), 이기수 2022.11.27(수정)
     * @param matCode
     * @return
     * {
     *     "name": "2022-11-27",
     *     "copper": 7991.00
     * }
     */
    @GetMapping("/price/{matCode}")
    public ResponseEntity<?> findPrice(@PathVariable String matCode){
        List<Map> price = priceService.findPrice(matCode);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}
