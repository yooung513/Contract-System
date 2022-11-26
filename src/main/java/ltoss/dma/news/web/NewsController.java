package ltoss.dma.news.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.repository.NewsRepository;
import ltoss.dma.news.service.NewsService;
import ltoss.dma.news.payload.NewsUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsRepository newsRepository;

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
    @GetMapping("news/{mat_code}")
    public ResponseEntity<?> find (@PathVariable() String mat_code) {

        List<News> news = newsService.findByMatCode(mat_code);

        return ResponseEntity.ok(news);

    }
   // @PatchMapping("/news/{mat_code}")
   // public ResponseEntity<?> updateNews(@RequestBody UpdateRequest updateRequest){
    //    Optional<News> news = NewsRepository.findById(updateRequest.getUserId());
    //}
    @DeleteMapping("news/{mat_code}")
    public ResponseEntity<?> deleteById(@PathVariable("newsId")Integer newsId){
        NewsService.deleteById(newsId);
        return  ResponseEntity.ok(new MessageResponse(newsId + "번 News 삭제 되었습니다"));
    }

    //수정
    @PatchMapping("news/{mat_code}")
    @Transactional
    public ResponseEntity<?>updateNews(@RequestBody NewsUpdateRequest newsUpdateRequest){
        Optional<News> news = newsService.findById(newsUpdateRequest.getNewsId());
        if (news.isEmpty()){
            return new ResponseEntity<>("변경할 내용이 없습니다.",HttpStatus.BAD_REQUEST);
        }
        newsRepository.updateNews(
                newsUpdateRequest.getNewsId(),
                newsUpdateRequest.getMatCode(),
                newsUpdateRequest.getDate(),
                newsUpdateRequest.getTitle(),
                newsUpdateRequest.getHyperLink(),
                newsUpdateRequest.getContents(),
                newsUpdateRequest.getRegCode(),
                newsUpdateRequest.getRegister(),
                newsUpdateRequest.getDate().atStartOfDay()
        );
       return ResponseEntity.ok(new MessageResponse(newsUpdateRequest.getNewsId()+ "번 new 정보 수정완료"));

    }



}
