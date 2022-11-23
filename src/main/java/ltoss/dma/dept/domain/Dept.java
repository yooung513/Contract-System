package ltoss.dma.dept.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
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

    @Column(name = "dept_level")
    private Integer deptLevel;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_dept_code")
    private Dept dept;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dept")
    private Set<Dept> deptSet = new HashSet<>();

}
