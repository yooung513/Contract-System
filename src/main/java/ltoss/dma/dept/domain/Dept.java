package ltoss.dma.dept.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dept")
public class Dept {

    @Id
    @Column(name = "dept_code", length = 20)
    @Size(max = 20)
    private String deptCode;

    @Column(name = "dept_name", length = 45)
    @Size(max = 45)
    private String deptName;
}
