package ltoss.dma.dashboard.repository;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DashboardDto {

    private String mat_code;

    private List<Integer> pricedata;

    public DashboardDto(){

    }

    public DashboardDto(LocalDate date, String mat_code){
        this.mat_code = mat_code;
        this.pricedata = pricedata;
    }

    public DashboardDto(String mat_code, List<Integer> pricedata){
        this.mat_code = mat_code;
        this.pricedata = pricedata;
    }
}
