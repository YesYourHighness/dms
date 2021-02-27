package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.RepairInsertForm;
import cn.yesmylord.dms.form.RepairUpdateDto;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface RepairlogService {

    ResponseVo showRepairLogList(Integer pageNum, Integer pageSize);

    ResponseVo insertRepair(RepairInsertForm repairInsertForm);

    ResponseVo updateRepair(RepairUpdateDto repairUpdateDto);

    ResponseVo deleteRepair(Integer id);

    ResponseVo SearchRepairById(Integer id ,Integer pageNum, Integer pageSize);
}
