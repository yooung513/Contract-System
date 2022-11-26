package ltoss.dma.dashboard.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.dashboard.domain.Dashboard;
import ltoss.dma.dashboard.repository.DashboardDto;
import ltoss.dma.dashboard.repository.DashboardRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    /**
     * 계약 정보 전체 조회
     * @return
     */
    public List<Dashboard> findAll() { return dashboardRepository.findAll(); }

    /**
     * 조건에 따른 계약 정보 조회
     * @param spec
     * @return
     */
    public List<DashboardDto> findAll(Specification spec) {

        List<Dashboard> dashboard = dashboardRepository.findAll(spec);
        List<DashboardDto> findPrice = dashboard.stream()
                .map(m -> new DashboardDto(m.getPrice()))
                .collect(Collectors.toList());

        return findPrice;
    }

}
