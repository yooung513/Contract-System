package ltoss.dma.dept.repository;

import ltoss.dma.dept.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept, String> {

    void deleteByDeptCode(String dept_code);

}
