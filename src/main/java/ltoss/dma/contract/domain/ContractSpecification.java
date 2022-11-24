package ltoss.dma.contract.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractSpecification {

    // 원자재
    public static Specification<Contract> equalMat(String mat_code) {
//        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("mat_code"), mat_code));
//    }
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("mat_code"), mat_code);
            }
        };
    }

    // 계약명
    public static Specification<Contract> likeContName(String cont_code) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("cont_code"), "%" + cont_code + "%");
            }
        };
    }

    // 계약일 조회
    public static Specification<Contract> betweenDate(LocalDate startdate, LocalDate enddate) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("cont_date"), startdate, enddate);
            }
        };
    }

    // 계약 id 조회
    public static Specification<Contract> equalContId (Integer cont_id) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("cont_id"), cont_id);
            }
        };
    }

    // 담당자 id 조회
    public static Specification<Contract> equalUserId (Integer user_id) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("user_id"), user_id);
            }
        };
    }

    // 진행상태 조회
    public static Specification<Contract> equalContStatus (String cont_status) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("cont_status"), cont_status);
            }
        };
    }

    // 계약금액_기준 금액 이상 값 조회 (최소값 입력)
    public static Specification<Contract> greaterPrice (BigDecimal min_price) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("cont_price"), min_price);
            }
        };
    }

    // 계약금액_기준 금액 이하 값 조회 (최대값 입력)
    public static Specification<Contract> lessPrice (BigDecimal max_price) {
        return new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("cont_price"), max_price);
            }
        };
    }

}