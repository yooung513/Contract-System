package ltoss.dma.dept.service;

import lombok.RequiredArgsConstructor;
import ltoss.dma.dept.domain.Dept;
import ltoss.dma.dept.repository.DeptRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;

    public void save(Dept dept) { deptRepository.save(dept); }

    public List<Dept> findAll() { return deptRepository.findAll(); }

    public void updateDept(Dept dept) { deptRepository.save(dept); }

    public void deleteByDeptCode(String dept_code) { deptRepository.deleteByDeptCode(dept_code); }
}
