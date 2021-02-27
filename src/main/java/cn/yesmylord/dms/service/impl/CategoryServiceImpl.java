package cn.yesmylord.dms.service.impl;

import cn.yesmylord.dms.domain.Category;
import cn.yesmylord.dms.enums.ResponseEnum;
import cn.yesmylord.dms.form.CategoryInsertForm;
import cn.yesmylord.dms.form.CategoryUpdateForm;
import cn.yesmylord.dms.mapper.CategoryMapper;
import cn.yesmylord.dms.service.CategoryService;
import cn.yesmylord.dms.utils.ResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo showCategoryList(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList  = categoryMapper.showCategoryList();
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo searchCategoryByName(String name, Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList  = categoryMapper.searchByName(name);
        PageInfo<Object> pageInfo = new PageInfo<>(page);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo updateCategory(CategoryUpdateForm categoryUpdateForm) {
        int status = categoryMapper.updateCategory(categoryUpdateForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo insertCategory(CategoryInsertForm categoryInsertForm) {
        int status = categoryMapper.insertCategory(categoryInsertForm);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }

    @Override
    public ResponseVo updateCategoryState(Integer categoryId) {
        int status = categoryMapper.updateCategoryState(categoryId);
        if(status!=1){
            return ResponseVo.error(ResponseEnum.ERROR);
        }else {
            return ResponseVo.success();
        }
    }
}
