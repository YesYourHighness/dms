package cn.yesmylord.dms.controller;

import cn.yesmylord.dms.form.CategoryInsertForm;
import cn.yesmylord.dms.form.CategoryUpdateForm;
import cn.yesmylord.dms.service.CategoryService;
import cn.yesmylord.dms.utils.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 董文浩
 * @Date 2021/2/9 11:28
 */
@RestController
@Api(tags = "类别表接口")
@Slf4j
public class CategoryController {
    @Resource
    private CategoryService categoryService;


    @GetMapping("/category/list")
    @ApiOperation("类别列表接口")
    public ResponseVo categoryList(@RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        return categoryService.showCategoryList(pageNum,pageSize);
    }

    @GetMapping("/category/search")
    @ApiOperation("类别按名称查找接口")
    public ResponseVo categorySearchByName(@RequestParam String name,
                                           @RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize){
        return categoryService.searchCategoryByName(name,pageNum,pageSize);
    }
    @PutMapping("/category/update")
    @ApiOperation("类别更新接口")
    public ResponseVo categoryUpdate(@Valid @RequestBody CategoryUpdateForm categoryUpdateForm){
        return categoryService.updateCategory(categoryUpdateForm);
    }

    @PostMapping("/category/insert")
    @ApiOperation("类别插入接口")
    public ResponseVo categoryUpdate(@Valid @RequestBody CategoryInsertForm categoryInsertForm){
        return categoryService.insertCategory(categoryInsertForm);
    }

    @DeleteMapping("/category/delete")
    @ApiOperation("类别删除接口")
    public ResponseVo categoryDelete(@RequestParam Integer categoryId){
        return categoryService.updateCategoryState(categoryId);
    }
}
