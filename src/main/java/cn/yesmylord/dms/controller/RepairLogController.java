package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.RepairInsertForm;
import cn.yesmylord.dms.form.RepairUpdateDto;
import cn.yesmylord.dms.service.RepairlogService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 董文浩
 * @Date 2021/2/9 11:29
 */
@RestController
@Api(tags = "维修日志表接口")
@Slf4j
public class RepairLogController {
    @Resource
    private RepairlogService repairlogService;

    @ApiOperation("维修日志列表")
    @GetMapping("/repair/list")
    public ResponseVo repairLogList(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "10") Integer pageSize) {
        return repairlogService.showRepairLogList(pageNum, pageSize);
    }

    @ApiOperation("维修日志新增")
    @PostMapping("/repair/insert")
    public ResponseVo repairLogInsert(@RequestBody @Valid RepairInsertForm repairInsertForm) {
        return repairlogService.insertRepair(repairInsertForm);
    }

    @ApiOperation("维修日志更新")
    @PutMapping("/repair/update")
    public ResponseVo repairLogUpdate(@RequestBody @Valid RepairUpdateDto repairUpdateDto) {
        return repairlogService.updateRepair(repairUpdateDto);
    }

    @ApiOperation("维修日志按日志ID查询")
    @GetMapping("/repair/search")
    public ResponseVo repairLogSearch(@RequestParam Integer id, @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        return repairlogService.SearchRepairById(id, pageNum, pageSize);
    }

    @ApiOperation("维修日志按日志ID查询")
    @DeleteMapping("/repair/delete")
    public ResponseVo repairLogDelete(@RequestParam Integer id) {
        return repairlogService.deleteRepair(id);
    }
}
