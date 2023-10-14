package com.wansui.controller;

import com.wansui.pojo.Headline;
import com.wansui.pojo.Type;
import com.wansui.pojo.vo.PortalVo;
import com.wansui.service.HeadlineService;
import com.wansui.service.TypeService;
import com.wansui.util.Result;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门户控制器
 *
 * @author wansui
 * @date 2023/10/14
 */

@RestController
@CrossOrigin
@RequestMapping("portal")
public class PortalController {
    @Autowired
    private TypeService  typeService;
    @Autowired
    private HeadlineService headlineService;

    /**
     * 获取所有分类
     *
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @GetMapping("findAllTypes")
    public Result findAllTypes() {

        List<Type> list = typeService.list();
        return Result.ok(list);
    }

    /**
     * 查找新闻页面
     *
     * @param portalVo
     * @return @return {@link Result }
     * @author wansui
     * @date 2023/10/14
     */
    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo){

        System.out.println( portalVo.toString());
        return headlineService.findNewsPage(portalVo);

    }

}
