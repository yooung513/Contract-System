package ltoss.dma.price.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.code.domain.Code;
import ltoss.dma.code.repository.CodeRepository;
import ltoss.dma.price.domain.Price;
import ltoss.dma.price.repository.JpaPriceRepository;
import ltoss.dma.price.repository.JpaPriceDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PriceService {

    private final JpaPriceRepository jpaPriceRepository;
    private final CodeRepository codeRepository;

    public Price save(Price price) {
        return jpaPriceRepository.save(price);
    }

    public List<Price> findAll() {
        return jpaPriceRepository.findAll();
    }

    public List<Price> findByDateBetween(LocalDate startDate, LocalDate endDate){
        return jpaPriceRepository.findByDateBetween(startDate,endDate);
    }

    /** 현재 날짜 기준 최근 30일간의 자재(mat_code = mat01,mat02) 가격 데이터를 반환한다.
     *  박남길 2022.11.25
     * @param matCode
     * @return
     * {
     *     "name": "2022-11-27",
     *     "copper": 7991.00
     * }
     */
    public List<Map> findPrice(String matCode){
        Optional<Code> code = codeRepository.findById(matCode);
        if(!code.isEmpty()) {
            String fieldName = code.get().getDescription();
            List<JpaPriceDto> jpaPriceDtoList = jpaPriceRepository.findByPrice(matCode);
            List<Map> results = new ArrayList<>();
            for(JpaPriceDto price: jpaPriceDtoList) {
                Map<String, Object> result = new HashMap<>();
                result.put("name", price.getDate());
                result.put(fieldName, price.getPrice());

                results.add(result);
            }
            return results;
        }
        return null;
    }


    /**
     * 가격 데이터가 잇는 원자재의 종류를 조회한다.
     * 이기수 2022.11.29
     * @return
     */
    public Set<Code> findKindOfPrice() {
        Set<String> matCodes = jpaPriceRepository.findKindOfPrice();
        Set<Code> codes = codeRepository.findDescriptionByIds(matCodes);
        return codes;
    }
}