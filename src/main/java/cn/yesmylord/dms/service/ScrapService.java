package cn.yesmylord.dms.service;

import cn.yesmylord.dms.form.ScrapInsertForm;
import cn.yesmylord.dms.form.ScrapUpdateForm;
import cn.yesmylord.dms.utils.ResponseVo;

/**
 * @author 董文浩
 * @Date 2021/2/3 13:59
 */
public interface ScrapService {

    ResponseVo showScrapList(Integer pageNum, Integer pageSize);

    ResponseVo searchScrapById(Integer id, Integer pageNum, Integer pageSize);

    ResponseVo insertScrap(ScrapInsertForm scrapInsertForm);

    ResponseVo updateScrap(ScrapUpdateForm scrapUpdateForm);

    ResponseVo deleteScrap(Integer id);
}
