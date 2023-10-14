package com.wansui.pojo.vo;

import lombok.Data;

/**
 * @author wansui
 * @date 2023/10/14
 */

@Data
public class PortalVo {
    
    private String keyWords;
    private Integer type;
    private Integer pageNum = 1;
    private Integer pageSize =10;
}