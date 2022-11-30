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
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;
    private final NewsRepository newsRepository;

    /**
     * 뉴스 데이터를 저장한다.
     * @param news
     * @return
     */
    @PostMapping("/news/copper")
    public ResponseEntity<?> saveCopperInfo(@RequestBody News[] news){
        for(News _news: news) {
            newsService.insert(_news);
        }
        return ResponseEntity.ok(new MessageResponse("뉴스 데이터를 저장하였습니다."));

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
        newsService.deleteById(newsId);
        return  ResponseEntity.ok(new MessageResponse(newsId + "번 News 삭제 되었습니다"));
    }

    //수정
    @PatchMapping("news/{mat_code}")
    @Transactional
    public ResponseEntity<?>updateNews(@RequestBody NewsUpdateRequest newsUpdateRequest){
        if( newsService.updateNews(newsUpdateRequest) ) {
            return ResponseEntity.ok(new MessageResponse("변경할 내용이 없습니다. 목록을 새롭게 조회해보세요."));
        }
        return ResponseEntity.ok(new MessageResponse(newsUpdateRequest.getNewsId()+ "번 new 정보 수정완료"));

    }

    /**
     * 뉴스 데이터 전체를 조회한다.
     * 이기수 2022.11.29
     */
    @GetMapping("/news/all")
    public ResponseEntity<?> getAllNews() {
        List<News> news = newsService.getAllNews();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }


}
