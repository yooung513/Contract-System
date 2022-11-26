package ltoss.dma.price.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.repository.JpaPriceRepository;
import ltoss.dma.price.repository.JpaPriceDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceService {

    private final JpaPriceRepository jpaPriceRepository;

    public Price save(Price price) {
        return jpaPriceRepository.save(price);
    }

    public List<Price> findAll() {
        return jpaPriceRepository.findAll();
    }

    public List<Price> findByDateBetween(
            @RequestParam("startDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam("endDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate){
        System.out.println("s startDate = " + startDate);
        System.out.println("s endDate = " + endDate);
        return jpaPriceRepository.findByDateBetween(startDate,endDate);
    }

//*JpaRepository에 jpql문으로 조회하는 메소드를 findPrice에 주입 하여 리턴//
    public List<JpaPriceDto> findPrice(String mat_code){

        return  jpaPriceRepository.findByPrice(mat_code);
    }




}



//    @Override
//    public void update(Integer priceid, PriceUpdateDto updateParam) {
//        Price findPrice = priceRepository.findById(priceid).orElseThrow();
//        findPrice.setPriceid(updateParam.getPriceid());
//        findPrice.setDate(updateParam.getDate());
//        findPrice.setMatcode(updateParam.getMatcode());
//        findPrice.setPrice(updateParam.getPrice());
//        findPrice.setUpdown(updateParam.getUpdown());
//        findPrice.setRate(updateParam.getRate());
//        findPrice.setStock(updateParam.getStock());
//        findPrice.setRegcode(updateParam.getRegcode());
//        findPrice.setRegister(updateParam.getRegister());
//        findPrice.setRegdate(updateParam.getRegdate());
//    }
//
//    @Override
//    public Optional<Price> findById(Integer id) {
//        return Optional.ofNullable(matprice.get(id));
//    }

//    @Override
//    public List<Price> findPrice(PriceSearchCond cond) {
//        LocalDate date = cond.getDate();
//        String matcode = cond.getMatcode();
//        return matprice.values().stream()
//                .filter(price -> {
//                    if (!isEmpty())
//                        }
//    }
//
//                    if (ObjectUtils.isEmpty(date)) {
//                        return true;
//                    }
//                    return price.getDate().equals(date);
//                }).filter(price -> {
//                    if (matcode == null) {
//                        return true;
//                    }
//                    return price.getMatcode() == matcode;
//                })
//                .collect(Collectors.toList());
//    }
//
//    public void clearMatPrice() {
//        matprice.clear();
//    }
//
//}

