package ltoss.dma.news.service;

import lombok.AllArgsConstructor;
import ltoss.dma.contract.domain.Contract;

import ltoss.dma.coop.domain.Coop;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.repository.NewsRepository;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsService {

    private static NewsRepository newsRepository;
    public void insert(News news) {
        news.setRegCode("hehe");
        newsRepository.save(news);
    }
    public List<News> findByMatCode(String matCode){
        return newsRepository.findAllByMatCode(matCode);
    }
    //삭제
    public static void deleteById(Integer newsId){
        newsRepository.deleteById(newsId);
    }
    //수정
//    public void update(News news){
//        newsRepository.save(news);

    public Optional<News> findById(Integer newsId){
        return newsRepository.findById(newsId);

    }



}
