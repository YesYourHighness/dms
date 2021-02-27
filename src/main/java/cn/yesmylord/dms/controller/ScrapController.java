package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.ScrapInsertForm;
import cn.yesmylord.dms.form.ScrapUpdateForm;
import cn.yesmylord.dms.service.ScrapService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 董文浩
 * @Date 2021/2/9 11:42
 */
@RestController
@Api(tags = "损坏设备表接口")
@Slf4j
public class ScrapController {
    @Resource
    private ScrapService scrapService;

    @ApiOperation("损坏设备表")
    @GetMapping("/scrap/list")
    public ResponseVo scrapList(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        return scrapService.showScrapList(pageNum, pageSize);
    }

    @ApiOperation("损坏设备表按ID查询查询")
    @GetMapping("/scrap/search")
    public ResponseVo scrapSearch(@RequestParam Integer id,
                                @RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        return scrapService.searchScrapById(id, pageNum, pageSize);
    }

    @ApiOperation("损坏设备表新增")
    @PostMapping("/scrap/insert")
    public ResponseVo scrapInsert(@RequestBody ScrapInsertForm scrapInsertForm) {
        return scrapService.insertScrap(scrapInsertForm);
    }
    @ApiOperation("损坏设备表更新")
    @PutMapping("/scrap/update")
    public ResponseVo scrapUpdate(@RequestBody ScrapUpdateForm scrapUpdateForm) {
        return scrapService.updateScrap(scrapUpdateForm);
    }
    @ApiOperation("损坏设备表更新")
    @DeleteMapping("/scrap/delete")
    public ResponseVo scrapUpdate(@RequestParam Integer id) {
        return scrapService.deleteScrap(id);
    }

}
