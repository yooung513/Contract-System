package ltoss.dma.dashboard.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.code.domain.Code;
import ltoss.dma.code.repository.CodeRepository;
import ltoss.dma.dashboard.domain.Dashboard;
import ltoss.dma.dashboard.repository.DashboardRepository;
import ltoss.dma.dashboard.repository.DashboardSummaryResponse;
import ltoss.dma.dashboard.repository.JpaDashboardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final CodeRepository codeRepository;

    /**
     * 계약 정보 전체 조회
     * @return
     */
    public List<Dashboard> findAll() { return dashboardRepository.findAll(); }

    /**
     * 현재 날짜 기준 7, 30, 90일 전의 가격 데이터를 반환한다.
     * 이다영 2022.11.28
     * @param mat_code
     * @return
     */
    public List<Map> findPrice(String mat_code) {
        Optional<Code> code = codeRepository.findById(mat_code);
        if(!code.isEmpty()) {
            List<JpaDashboardDto> dashboardDtoList = dashboardRepository.findByPrice(mat_code);
            List<Map> results = new ArrayList<>();

            for (int i = 1; i < 4; i++) {
                for(JpaDashboardDto price: dashboardDtoList) {
                    Map<String, Object> result = new HashMap<>();

                    if(i == 1) {
                        result.put("sortation", "최대값");
                        result.put("week", price.getWeekMaxPrice());
                        result.put("month", price.getMonthMaxPrice());
                        result.put("quarter", price.getQuarterMaxPrice());
                    }
                    else if(i == 2){
                        result.put("sortation", "최소값");
                        result.put("week", price.getWeekMinPrice());
                        result.put("month", price.getMonthMinPrice());
                        result.put("quarter", price.getQuarterMinPrice());
                    }
                    else {
                        result.put("sortation", "평균값");
                        result.put("week", price.getWeekAvgPrice());
                        result.put("month", price.getMonthAvgPrice());
                        result.put("quarter", price.getQuarterAvgPrice());
                    }
                    results.add(result);
                }
            }
            return results;
        }
        return null;
    }

    /**
     * 기준 주, 월, 분기별 가격 요약 데이터를 조회한다.
     * 이기수 2022.11.29
     * @return
     */
    public List<DashboardSummaryResponse> getDashboardSummary(String matCode) {
        return dashboardRepository.getDashboardSummary(matCode);
    }
}
