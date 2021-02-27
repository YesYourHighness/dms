package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.CategoryInsertForm;
import cn.yesmylord.dms.form.CategoryUpdateForm;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface CategoryService {

    ResponseVo showCategoryList(Integer pageNum, Integer pageSize);

    ResponseVo searchCategoryByName(String name, Integer pageNum, Integer pageSize);

    ResponseVo updateCategory(CategoryUpdateForm categoryUpdateForm);

    ResponseVo insertCategory(CategoryInsertForm categoryInsertForm);

    ResponseVo updateCategoryState(Integer categoryId);
}
