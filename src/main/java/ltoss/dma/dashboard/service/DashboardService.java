package ltoss.dma.dashboard.service;

import lombok.AllArgsConstructor;
import ltoss.dma.dashboard.repository.DashboardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DashboardService {

    public DashboardDto findByMatCode(String matCode) {
        DashboardDto dto = new DashboardDto();
        return dto;
    }
}
