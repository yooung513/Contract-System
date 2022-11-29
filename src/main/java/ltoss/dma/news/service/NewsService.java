package ltoss.dma.news.service;

import lombok.AllArgsConstructor;
import ltoss.dma.contract.domain.Contract;

import ltoss.dma.coop.domain.Coop;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.payload.NewsUpdateRequest;
import ltoss.dma.news.repository.NewsRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void insert(News news) {
        news.setRegCode("hehe");
        newsRepository.save(news);
    }
    public List<News> findByMatCode(String matCode){
        return newsRepository.findAllByMatCode(matCode);
    }

    //삭제
    public void deleteById(Integer newsId){
        newsRepository.deleteById(newsId);
    }
    //수정
//    public void update(News news){
//        newsRepository.save(news);

    public Optional<News> findById(Integer newsId){
        return newsRepository.findById(newsId);

    }

    /**
     * 뉴스 데이터 전체를 조회한다.
     * 이기수 2022.11.29
     * @return
     */
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    /**
     * 뉴스 데이터 하나를 수정한다.
     * 이기수 2022.11.29
     */
    public boolean updateNews(NewsUpdateRequest newsUpdateRequest) {
        Optional<News> news = newsRepository.findById(newsUpdateRequest.getNewsId());
        if (news.isEmpty()){
            return true;
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
        return false;
    }
}
