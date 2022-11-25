package ltoss.dma.news.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class NewsUpdateRequest {
    @NotBlank
    private  Integer newsId;
    @NotBlank
    private String matCode;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private  String title;
    @NotBlank
    private String hyperLink;
    @NotBlank
    private  String contents;
    @NotBlank
    private  String regCode;
    @NotBlank
    private  String register;
    @NotBlank
    private LocalDateTime regDate;
}
