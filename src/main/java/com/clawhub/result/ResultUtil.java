package com.clawhub.result;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.clawhub.constants.StatusParamConstant;

import java.util.Date;

/**
 * <Description> 返回结果工具类 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
public class ResultUtil {
    /**
     * DATEFORMAT yyyy-MM-dd HH:mm:ss
     */
    private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * mapping
     */
    private static SerializeConfig mapping = new SerializeConfig();

    /**
     * 静态构造
     */
    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer(DATEFORMAT));
    }

    /**
     * Description: 获取带对象正确的json字符串，并处理日期格式默认yyyy-MM-dd HH:mm:ss <br>
     *
     * @param obj obj
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_SUCC, obj), mapping,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 返回正确信息，有正确码 <br>
     *
     * @param obj         obj
     * @param messageCode message code
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, String messageCode) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_SUCC, new RtnMessage(messageCode), obj),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description:返回正确信息，有正确码,带占位符信息 <br>
     *
     * @param obj         obj
     * @param messageCode message code
     * @param msg         msg
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, String messageCode, Object... msg) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_SUCC, new RtnMessage(messageCode, msg), obj),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 有正确码,返回信息 <br>
     *
     * @param messageCode message code
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(String messageCode) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_SUCC, new RtnMessage(messageCode)),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 有正确码,带占位符信息<br>
     *
     * @param messageCode message code
     * @param msg         msg
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(String messageCode, Object... msg) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_SUCC, new RtnMessage(messageCode, msg)),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串 <br>
     *
     * @param errorCode error code
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getError(String errorCode) {
        return JSONObject.toJSONString(new ResultInfo<>(StatusParamConstant.RESULT_ERROR, new RtnMessage(errorCode)),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }
}