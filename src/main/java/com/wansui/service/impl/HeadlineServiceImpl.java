package com.wansui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.Headline;
import com.wansui.pojo.vo.PortalVo;
import com.wansui.service.HeadlineService;
import com.wansui.mapper.HeadlineMapper;
import com.wansui.util.Result;
import com.wansui.util.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wansui
 * @date 2023/10/14
 * @see ServiceImpl
 * @see HeadlineService
 */

@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private HeadlineMapper headlineMapper;


    /**
     * 查找新闻页面
     *
     * @param portalVo 门户网站数据
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @Override
    public Result findNewsPage(PortalVo portalVo) {

        Page<Headline> page = new Page<>(portalVo.getPageNum(), portalVo.getPageSize());

        headlineMapper.selectMyPage(page,portalVo);
        Map<String,Object> pageInfo =new HashMap<>();
        pageInfo.put("pageData",page.getRecords());
        pageInfo.put("pageNum",page.getCurrent());
        pageInfo.put("pageSize",page.getSize());
        pageInfo.put("totalPage",page.getPages());
        pageInfo.put("totalSize",page.getTotal());

        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("pageInfo",pageInfo);
        // 响应JSON
        return Result.ok(pageInfoMap);

    }

    /**
     * 显示标题详细信息
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/15
     */
    @Override
    public Result showHeadlineDetail(Integer hid) {

        Map headlineMap=headlineMapper.getHeadlineMap(hid);
        Map data = new HashMap();
        int version = (int) headlineMap.get("version");
        headlineMap.remove("version");

        data.put("headline",headlineMap);

        Headline headline = new Headline();
        headline.setHid((Integer) headlineMap.get("hid"));
        headline.setVersion((Integer) headlineMap.get("version"));
        headline.setPageViews((Integer) headlineMap.get("pageViews")+1);
        headlineMapper.updateById(headline);

        return Result.ok(data);
    }

    /**
     * 出版
     *
     * @param headline 标题
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    @Override
    public Result publish(Headline headline) {
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headline.setPageViews(0);
        headlineMapper.insert(headline);

        return Result.ok(null);

    }

    /**
     * 按隐藏查找标题
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    @Override
    public Result findHeadlineByHid(Integer hid) {

        Headline headline = headlineMapper.selectById(hid);
        if(headline!=null){
            HashMap<String,Headline> data = new HashMap<>();
            data.put("headline",headline);
            return Result.ok(data);
        }
        return Result.build(null,512,"文章不存在");
    }

    @Override
    public Result update(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        int i = headlineMapper.updateById(headline);
        if(i>0){
            return Result.ok(null);
        }else{
            return Result.build(null, 511,"更新失败");
        }

    }

    @Override
    public Result removeByHid(Integer hid) {

        headlineMapper.deleteById(hid);

        return Result.ok(null);

    }
}




