package com.clawhub.common;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * <Description>基础controller <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年10月26日 <br>
 */

public class BaseController {
    /**
     * dubbo请求超时时间 单位：毫秒
     */
    public static final int TIME_OUT = 6000;

    /**
     * Description: 后端请求的拦截器植入信息<br>
     *
     * @param request request
     * @return <br>
     * @author LiZhiming<br>
     * @taskId <br>
     */
    protected JSONObject getManagerLoginInfo(HttpServletRequest request) {
        JSONObject ctrParams = new JSONObject();
        ctrParams.put("userId", request.getAttribute("userId"));
        ctrParams.put("UserName", request.getAttribute("UserName"));
        return ctrParams;
    }
}
