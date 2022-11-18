package ltoss.dma.price.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.repository.JpaPriceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceService {

    private final JpaPriceRepository JpaPriceRepository;

    public Price save(Price price) {
        return JpaPriceRepository.save(price);
    }

    public List<Price> findAll(){
        return JpaPriceRepository.findAll();
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

