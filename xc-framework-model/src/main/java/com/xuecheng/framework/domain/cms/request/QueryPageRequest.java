package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;

/**
 * Fighting
 *
 * @Author Mr.XiongKF
 * @Date 2018/11/20
 * If you don't work hard, no one can give you the life you want!
 **/
@Data
public class QueryPageRequest extends RequestData {
   //站点id
    private String siteId;
    //页面id
    private String pageId;
    //页面名称
    private String pageName;
    //别名
    private String pageAliase;
    //模板id
    private String templateId;

}
