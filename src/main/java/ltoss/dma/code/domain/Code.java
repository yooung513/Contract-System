package ltoss.dma.code.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Data
@Entity
@Table(name = "code_master")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Code implements Serializable {

    @Id
    @Column(name = "code", length = 20)
    private String code;

    @Column(name = "type", length = 45)
    private String type;

    @Column(name = "description", length = 100)
    private String description;
}
