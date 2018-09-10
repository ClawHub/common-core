package com.clawhub.exception;

import com.alibaba.fastjson.JSONObject;
import com.clawhub.constants.ParamConstant;
import com.clawhub.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <Description> ExceptionHandle<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-10 <br>
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    /**
     * Exception get string.
     *
     * @param e     the e
     * @param local the local
     * @return the string
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionGet(Exception e, String local) {
        logger.debug("异常类型：" + e.getClass());
        String msg = e.getMessage();
        logger.info("异常信息：" + msg);
        //获取第一个点的位置
        int beginIndex = msg.indexOf(ParamConstant.SEPARATOR);
        logger.debug("beginIndex:" + beginIndex);
        //不是自定义异常，返回系统异常
        if (beginIndex == ParamConstant.ERROR) {
            return ResultUtil.getError("-1", "系统异常");
        }
        //根据第一个点的位置 获得第二个点的位置
        int endIndex = msg.indexOf(ParamConstant.SEPARATOR, beginIndex + 1);
        JSONObject obj = JSONObject.parseObject(msg.substring(beginIndex + ParamConstant.SEPARATOR.length(), endIndex));
        //错误码
        String code = obj.getString(ParamConstant.CODE);
        logger.debug("code：" + code);
        //错误信息
        String message = obj.getString(ParamConstant.MESSAGE);
        logger.debug("message：" + message);
        return ResultUtil.getError(code, message);
    }
}
