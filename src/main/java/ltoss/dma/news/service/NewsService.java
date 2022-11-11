package ltoss.dma.news.service;

import lombok.AllArgsConstructor;
import ltoss.dma.news.domain.News;
import ltoss.dma.news.repository.NewsRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsService {

    private NewsRepository newsRepository;

    public void insert(News news) {
        news.setReg_code("hehe");
        newsRepository.save(news);
    }
}
