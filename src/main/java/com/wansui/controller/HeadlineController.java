package com.wansui.controller;

import com.wansui.pojo.Headline;
import com.wansui.service.HeadlineService;
import com.wansui.util.JwtHelper;
import com.wansui.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 标题控制器
 *
 * @author wansui
 * @date 2023/10/16
 */
@RestController
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private HeadlineService headlineService;
    /**
     * 出版
     *
     * @param data 数据
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/16
     */
    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token){
        headline.setPublisher(jwtHelper.getUserId(token));
       return  headlineService.publish(headline);
    }

    /**
     * 按隐藏查找标题
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid){
        return headlineService.findHeadlineByHid(hid);

    }

    /**
     * 更新
     *
     * @param headline 标题
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    @PostMapping("update")
    public Result Update(@RequestBody Headline headline){
        return headlineService.update(headline);
    }

    /**
     * 按ID删除
     *
     * @param hid 藏起
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/17
     */
    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid){
        return headlineService.removeByHid(hid);
    }
}
