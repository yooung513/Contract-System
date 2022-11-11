package ltoss.dma.exchangerate.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@Getter
@NoArgsConstructor
public class ExchangeRate {

    /**
     * result: Integer // 조회 결과
     * cur_unit: String // 통화코드
     * cur_nm: String // 국가/통화명
     * ttb: String // 전신환(송금) 받으실 때
     * tts: String // 전신환(송금) 보내실 때
     * deal_bas_r: String // 매매 기준율
     * bkpr: String // 장부가격
     * yy_efee_r: String // 년환가료율
     * ten_dd_efee_r: String // 10일환가료율
     * kftc_deal_bas_r: String // 서울외국환중개매매기준율
     * kftc_bkpr: String // 서울외국환중개장부가격
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private Long result;
    private String curUnit;
    private String curNm;
    private String ttb;
    private String tts;
    private String dealBasR;
    private String bkpr;
    private String yyEfeeR;
    private String tenDdEfeeR;
    private String kftcDealBasR;
    private String kftcBkpr;
    private LocalDate curDate;

    @Builder
    public ExchangeRate(Long idx, Long result, String curUnit, String curNm, String ttb, String tts, String dealBasR, String bkpr, String yyEfeeR, String tenDdEfeeR, String kftcDealBasR, String kftcBkpr, LocalDate curDate) {
        this.idx = idx;
        this.result = result;
        this.curUnit = curUnit;
        this.curNm = curNm;
        this.ttb = ttb;
        this.tts = tts;
        this.dealBasR = dealBasR;
        this.bkpr = bkpr;
        this.yyEfeeR = yyEfeeR;
        this.tenDdEfeeR = tenDdEfeeR;
        this.kftcDealBasR = kftcDealBasR;
        this.kftcBkpr = kftcBkpr;
        this.curDate = curDate;
    }
}