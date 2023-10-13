package com.wansui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wansui.pojo.Headline;
import com.wansui.service.HeadlineService;
import com.wansui.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-10-13 15:36:58
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




