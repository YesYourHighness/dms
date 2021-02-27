package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.domain.Category;
import cn.yesmylord.dms.form.CategoryInsertForm;
import cn.yesmylord.dms.form.CategoryUpdateForm;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface CategoryMapper {

    List<Category> showCategoryList();

    List<Category> searchByName(String name);

    int updateCategory(CategoryUpdateForm categoryUpdateForm);

    int insertCategory(CategoryInsertForm categoryInsertForm);

    int updateCategoryState(Integer categoryId);
}