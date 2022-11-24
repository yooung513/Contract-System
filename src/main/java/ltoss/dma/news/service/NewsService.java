package ltoss.dma.news.service;

import lombok.AllArgsConstructor;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.repository.NewsRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {

    private NewsRepository newsRepository;

    public void insert(News news) {

        news.setRegCode("hehe");

        newsRepository.save(news);
    }
    //  public List<News> findByMatCode(String mat_code) {
    //      return newsRepository.findBy(mat_code);
    //  }
    public List<News> findByMatCode(String matCode){
        return newsRepository.findAllByMatCode(matCode);
    }

}
