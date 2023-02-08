package cn.meshed.cloud.iam.rbac.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.rbac.Role;
import cn.meshed.cloud.iam.domain.rbac.gateway.RoleGateway;
import cn.meshed.cloud.iam.dto.rbac.RoleQry;
import cn.meshed.cloud.iam.dto.rbac.data.RoleDTO;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1></h1>
 *
 * @version 1.0
 * @author Vincent Vic
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class RoleListQryExe implements CommandExecute<RoleQry, SingleResponse<List<RoleDTO>>> {

    private final RoleGateway roleGateway;

    /**
     * @param roleQry
     * @return
     */
    @Override
    public SingleResponse<List<RoleDTO>> execute(RoleQry roleQry) {
        List<Role> roles = roleGateway.searchList(roleQry);
        return ResultUtils.copyList(roles,RoleDTO::new);
    }
}
