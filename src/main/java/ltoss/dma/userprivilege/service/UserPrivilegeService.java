/**
 *  user_privilege service 등록
 *  이름 : 강성욱
 *
 */
package ltoss.dma.userprivilege.service;

import lombok.RequiredArgsConstructor;

import ltoss.dma.login.models.UserPrivilege;
import ltoss.dma.login.repository.UserPrivilegeRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPrivilegeService {
    private final UserPrivilegeRepository userprivilegeRepository;

    // Create
    public void insert (UserPrivilege userprivilege) { userprivilegeRepository.save(userprivilege); }

    // Read
    public List<UserPrivilege> findAll() {
        return userprivilegeRepository.findAll();
    }

    // Update
    public void update (UserPrivilege userprivilege) { userprivilegeRepository.save(userprivilege); }

    // Delete
    public void delete(UserPrivilege userprivilege) { userprivilegeRepository.deleteById(userprivilege.getUserPriId()); }
}
