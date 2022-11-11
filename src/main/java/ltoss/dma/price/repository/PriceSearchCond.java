package ltoss.dma.price.repository;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PriceSearchCond {

    private LocalDate date;

    private String matcode;

    public PriceSearchCond() {
    }

    public PriceSearchCond(LocalDate date,
                           String matcode){
        this.date = date;
        this.matcode = matcode;
    }
}
