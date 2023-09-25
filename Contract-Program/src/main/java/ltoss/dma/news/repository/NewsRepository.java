package ltoss.dma.news.repository;

import ltoss.dma.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer>{
    @Modifying
    @Query(value = "update news ui" +
            " set ui.matCode = :matCode"+
            " , ui.date = :date"+
            " , ui.title = :title"+
            " , ui.hyperlink = :hyperLink"+
            " , ui.contents = :contents"+
            " , ui.regCode = :regCode"+
            " , ui.register = :register"+
            " , ui.regDate = :regDate"+
            " where ui.newsId = :newsId", nativeQuery =true)
    int updateNews(
            @Param("newsId") Integer newsId,
            @Param("matCode") String matCode,
            @Param("date") LocalDate date,
            @Param("title") String title,
            @Param("hyperLink") String hyperLink,
            @Param("contents") String contents,
            @Param("regCode") String regCode,
            @Param("register") String register,
            @Param("regDate") LocalDateTime regDate
    );

    List<News> findAllByMatCode(String matCode);




}





