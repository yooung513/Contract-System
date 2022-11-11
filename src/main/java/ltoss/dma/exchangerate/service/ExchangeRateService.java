package ltoss.dma.exchangerate.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.exchangerate.domain.ExchangeRate;
import ltoss.dma.exchangerate.repository.ExchangeRateRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
@Slf4j
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    public boolean loadJson(String date) {
        log.debug("date={}", date);
        String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=2X6CLUZnQlY0bxuKuhAETYYptxrIIWMg&searchdate=" + date + "&data=AP01";
        BufferedReader bf;

        try {
            // 포맷터
            LocalDate curDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

            String json = getJsonFromUrl(url);

            if(json.length() > 0) {
                JSONParser jsonParser = new JSONParser();
                JSONArray jsonArray = (JSONArray) jsonParser.parse(json);

                if (jsonArray.size() > 0) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject tmp = (JSONObject) jsonArray.get(i);
                        log.debug((String) tmp.get("cur_nm"));

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
                        ExchangeRate infoObj = ExchangeRate.builder()
                                .result((Long) tmp.get("result"))
                                .curUnit((String) tmp.get("cur_unit"))
                                .curNm((String) tmp.get("cur_nm"))
                                .ttb((String) tmp.get("ttb"))
                                .tts((String) tmp.get("tts"))
                                .dealBasR((String) tmp.get("deal_bas_r"))
                                .bkpr((String) tmp.get("bkpr"))
                                .yyEfeeR((String) tmp.get("yy_efee_r"))
                                .tenDdEfeeR((String) tmp.get("ten_dd_efee_r"))
                                .kftcDealBasR((String) tmp.get("kftc_deal_bas_r"))
                                .kftcBkpr((String) tmp.get("kftc_bkpr"))
                                .curDate(curDate)
                                .build();

                        exchangeRateRepository.save(infoObj);
                    }
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private static String getJsonFromUrl(String requestUrl) throws IOException {
        BufferedReader bf;
        String result;
        bf = new BufferedReader(new InputStreamReader(new URL(requestUrl).openStream(), "UTF-8"));
        result = bf.readLine();

        log.debug(result.toString());

        return result;
    }

    public void insert(ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);
    }
}