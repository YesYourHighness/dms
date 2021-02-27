package cn.yesmylord.dms.mapper;

import cn.yesmylord.dms.dto.ScrapDto;
import cn.yesmylord.dms.form.ScrapInsertForm;
import cn.yesmylord.dms.form.ScrapUpdateForm;

import java.util.List;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface ScrapMapper {

    List<ScrapDto> showScrapList();

    int updateScrapState(Integer id);

    int updateScrap(ScrapUpdateForm scrapUpdateForm);

    int insertScrap(ScrapInsertForm scrapInsertForm);

    List<ScrapDto> searchScrapById(Integer id);
}