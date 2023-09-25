package ltoss.dma.login.repository;

import ltoss.dma.login.models.UserPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<UserPrivilege, Integer> {
    @Query(
            value = "update user_privilege up " +
                    "   set up.user_id = :userId " +
                    "     , up.privilege_id = :privilegeId " +
                    " where up.user_pri_id = :userPriId ",
            nativeQuery = true
    )
    void updateUserPrivilege(
            @Param("userPriId") Integer userPriId,
            @Param("userId") Long userId,
            @Param("privilegeId") Integer privilegeId
            );
}
