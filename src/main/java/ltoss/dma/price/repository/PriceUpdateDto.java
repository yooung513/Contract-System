package ltoss.dma.price.repository;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PriceUpdateDto {

    private Integer priceid;

    private LocalDate date;

    @Column(name = "matcode", length = 20)
    private String matcode;

    @Column(name = "prcie", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "updown", precision = 10, scale = 2)
    private BigDecimal updown;

    @Column(name = "rate", precision = 10, scale = 2)
    private BigDecimal rate;

    @Column(name = "stock", precision = 10, scale = 2)
    private BigDecimal stock;

    @Column(name = "regcode", length = 5)
    private String regcode;

    @Column(name = "register", length = 45)
    private String register;

    private LocalDate regdate;


    private LocalDate startDate;
    private LocalDate endDate;

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public PriceUpdateDto() {
    }

    public PriceUpdateDto (Integer priceid,
                          LocalDate date,
                          String matcode,
                          BigDecimal price,
                          BigDecimal updown,
                          BigDecimal rate,
                          BigDecimal stock,
                          String regcode,
                          String register,
                          LocalDate regdate) {
        this.priceid = priceid;
        this.date = date;
        this.matcode = matcode;
        this.price = price;
        this.updown = updown;
        this.rate = rate;
        this.stock = stock;
        this.regcode = regcode;
        this.register = register;
        this.regdate = regdate;
    }

//    public Price toEntity() {
//        return new Price(priceid, date, matcode, price, updown, rate, stock,
//                stock, regcode, register, regdate);
//    }
}
