package ltoss.dma.news.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.service.NewsService;
import org.apache.catalina.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    //저장
    @PostMapping("/news/copper")
    public String saveCopperInfo(@RequestBody News[] news){
        for(News _news: news) {
            log.debug("date = {}", _news.getDate());
            log.debug("mat_code = {}", _news.getMatCode());
            log.debug("contents = {}", _news.getContents());
            log.debug("title = {}", _news.getTitle());
            log.debug("news = {}", _news);

            newsService.insert(_news);
        }

        return "ok";
    }
    //조회
    @GetMapping(value = "news/{mat_code}")
        public ResponseEntity<?> find (@PathVariable String mat_code) {

        List<News> news = newsService.findByMatCode(mat_code);

        return ResponseEntity.ok(news);

    }

    //수정





}
