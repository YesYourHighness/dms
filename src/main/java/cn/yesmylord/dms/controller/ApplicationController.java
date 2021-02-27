package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.ApplicationInsertForm;
import cn.yesmylord.dms.form.ApplicationUpdateForm;
import cn.yesmylord.dms.service.ApplicationService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 董文浩
 * @Date 2021/2/9 11:21
 */
@RestController
@Api(tags = "申请表通用接口")
@Slf4j
public class ApplicationController {
    @Resource
    private ApplicationService applicationService;

    @GetMapping("/application/list")
    @ApiOperation("申请表列表信息")
    public ResponseVo applicationList(@RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize){
        return applicationService.showApplicationList(pageNum,pageSize);
    }
    @GetMapping("/application/search")
    @ApiOperation("申请设备名称查询")
    public ResponseVo applicationSearch(@RequestParam(defaultValue = "1") String name,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                      @RequestParam(defaultValue = "10") Integer pageSize){
        return applicationService.searchApplication(name,pageNum,pageSize);
    }

    @PutMapping("/application/update")
    @ApiOperation("申请设备信息修改")
    public ResponseVo applicationUpdate(@Valid @RequestBody ApplicationUpdateForm applicationUpdateForm){
        return applicationService.updateApplication(applicationUpdateForm);
    }

    @PostMapping("/application/insert")
    @ApiOperation("申请设备信息新增")
    public ResponseVo applicationInsert(@Valid @RequestBody ApplicationInsertForm applicationInsertForm){
        return applicationService.insertApplication(applicationInsertForm);
    }

    @DeleteMapping("/application/delete")
    @ApiOperation("申请设备信息删除")
    public ResponseVo applicationDelete(@RequestParam Integer id){
        return applicationService.updateApplicationState(id);
    }

}
