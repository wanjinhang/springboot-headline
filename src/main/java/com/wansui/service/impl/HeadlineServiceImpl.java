package com.wansui.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.Headline;
import com.wansui.pojo.vo.PortalVo;
import com.wansui.service.HeadlineService;
import com.wansui.mapper.HeadlineMapper;
import com.wansui.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}




