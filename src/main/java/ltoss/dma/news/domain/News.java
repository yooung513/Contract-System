package ltoss.dma.news.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Data
@EntityListeners(AuditingEntityListener.class)
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Integer news_id;

    @Column(name = "mat_code")
    private String mat_code;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title")
    private String title;

    @Column(name = "hyperlink")
    private String hyperlink;

    @Column(name = "contents")
    private String contents;

    @Column(name = "reg_code", length = 5)
    private String reg_code;

    @Column(name = "register")
    private String register;

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime reg_date;

}
