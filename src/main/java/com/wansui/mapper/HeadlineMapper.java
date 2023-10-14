package com.wansui.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wansui.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wansui.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author Administrator
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2023-10-13 15:36:58
* @Entity com.wansui.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    /**
     * @param page
     * @param portalVo
     * @return
     */
    IPage<Map> selectMyPage(IPage<Headline> page,
                            @Param("portalVo") PortalVo portalVo);
}




