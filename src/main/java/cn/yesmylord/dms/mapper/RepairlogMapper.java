package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.domain.Repairlog;
import cn.yesmylord.dms.dto.RepairDto;
import cn.yesmylord.dms.form.RepairInsertForm;
import cn.yesmylord.dms.form.RepairUpdateDto;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface RepairlogMapper {

    List<RepairDto> showRepairLogList();

    int insertRepair(RepairInsertForm repairInsertForm);

    int updateRepair(RepairUpdateDto repairUpdateDto);

    int updateRepairState(Integer id);

    List<RepairDto> searchById(Integer id);
}