package com.wansui.service;

import com.wansui.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wansui.pojo.vo.PortalVo;
import com.wansui.util.Result;

/**
* @author Administrator
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-10-13 15:36:58
*/
public interface HeadlineService extends IService<Headline> {

    /**
     * 获取分页查询首页头条信息
     *
     * @param portalVo 通向你门户
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/15
     */
    Result findNewsPage(PortalVo   portalVo);

    /**
     * 显示标题详细信息
     *
     * @param hid 文章Id
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/15
     */
    Result showHeadlineDetail(Integer hid);

    /**
     * 出版
     *
     * @param headline 标题
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    Result publish(Headline headline);

    /**
     * 按隐藏查找标题
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    Result findHeadlineByHid(Integer hid);

    /**
     * 更新
     *
     * @param headline 标题
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    Result update(Headline headline);

    /**
     * 按HID删除
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    Result removeByHid(Integer hid);
}
