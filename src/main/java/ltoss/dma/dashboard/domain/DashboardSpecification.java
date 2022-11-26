package ltoss.dma.dashboard.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class DashboardSpecification {

    // 원자재
    public static Specification<Dashboard> equalMat(String mat_code) {
        return new Specification<Dashboard>() {
            @Override
            public Predicate toPredicate(Root<Dashboard> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("mat_code"), mat_code);
            }
        };
    }

    // 계약일 조회
    public static Specification<Dashboard> betweenDate(LocalDate startdate, LocalDate enddate) {
        return new Specification<Dashboard>() {
            @Override
            public Predicate toPredicate(Root<Dashboard> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("date"), startdate, enddate);
            }
        };
    }
}