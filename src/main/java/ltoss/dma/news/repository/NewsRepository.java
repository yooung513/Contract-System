package ltoss.dma.news.repository;

import lombok.Builder;
import ltoss.dma.news.domain.News;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{

    //  static List<News> findAllByMatCode(String matCode) {
    // }

    List<News> findAllByMatCode(String matCode);

}





