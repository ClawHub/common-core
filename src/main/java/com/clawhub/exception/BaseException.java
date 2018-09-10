package com.clawhub.exception;


import com.alibaba.fastjson.JSONObject;
import com.clawhub.constants.ParamConstant;
import com.clawhub.util.ResourceUtil;

/**
 * <Description> BaseException<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-10 <br>
 */
public class BaseException extends RuntimeException {

    /**
     * The Code.
     */
    private String code;

    /**
     * The Message map.
     */
    private String message;

    /**
     * Instantiates a new Base exception.
     *
     * @param code the code
     * @param args the args
     */
    private BaseException(String code, Object... args) {
        this.code = code;
        this.message = ResourceUtil.getMessage(code, args);
    }

    /**
     * Gets instance.
     *
     * @param code the code
     * @param args the args
     * @return the instance
     */
    public static BaseException getInstance(String code, Object... args) {
        BaseException exception = new BaseException(code, args);
        exception.setStackTrace(new StackTraceElement[]{});
        return exception;
    }

    /**
     * Description: Get message <br>
     *
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public String getMessage() {
        JSONObject obj = new JSONObject();
        obj.put(ParamConstant.CODE, code);
        obj.put(ParamConstant.MESSAGE, message);
        //Dubbo会将自定义异常转为RuntimeException
        return ParamConstant.SEPARATOR + obj.toJSONString() + ParamConstant.SEPARATOR;
    }

}
