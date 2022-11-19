package ltoss.dma.news.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.service.NewsService;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/news/save")
    public ResponseEntity<?> saveCopperInfo(@RequestBody News[] news){
        for(News _news: news) {
            log.debug("date = {}", _news.getDate());
            log.debug("mat_code = {}", _news.getMat_code());
            log.debug("contents = {}", _news.getContents());
            log.debug("title = {}", _news.getTitle());
            log.debug("news = {}", _news);

            newsService.insert(_news);
        }
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
