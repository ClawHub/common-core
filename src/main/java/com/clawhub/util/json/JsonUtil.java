package com.clawhub.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.clawhub.constants.ParamConst;

import java.util.Date;
import java.util.List;

/**
 * <Description> json工具类 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
public class JsonUtil {
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
    public static String getSucc4Date(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), mapping, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带对象正确的json字符串，自定义配置格式 <br>
     *
     * @param obj        obj
     * @param jsonConfig json config
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializeConfig jsonConfig) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), jsonConfig, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带有对象的正确结果的json字符串<br>
     *
     * @param obj obj
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带有对象的正确结果的json字符串 <br>
     *
     * @param obj obj
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc4data(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
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
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode), obj),
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
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode, msg), obj),
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
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode)),
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
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode, msg)),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description:  获取自定义fileter和features特性 <br>
     *
     * @param obj      obj
     * @param filter   filter
     * @param features features
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializeFilter filter, SerializerFeature... features) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                ParamConst.RESULT_SUCC, obj), filter, features);
    }

    /**
     * Description: 获取自定义features特性 <br>
     *
     * @param obj      obj
     * @param features features
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializerFeature... features) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                ParamConst.RESULT_SUCC, obj), features);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串 <br>
     *
     * @param errorCode error code
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getErrorJson(String errorCode) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, new RtnMessage(errorCode)), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串 输出带有占位符 <br>
     *
     * @param errorCode error code
     * @param obj       obj
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getErrorJsonWithObj(String errorCode, Object... obj) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, new RtnMessage(errorCode, obj)), SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串 <br>
     *
     * @param errorCode error code
     * @param errorMsg  error msg
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getErrorJson(String errorCode, String errorMsg) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, new RtnMessage(errorCode, errorMsg)), SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description:多个错误信息的json字符串 <br>
     *
     * @param rtnMsgs rtn msgs
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getErrorJson(List<RtnMessage> rtnMsgs) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, rtnMsgs), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带有对象的错误信息json字符串<br>
     *
     * @param obj obj
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static String getErrorJson4data(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, obj), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取json字符串成功标志码<br>
     *
     * @param jsonStr json str
     * @return boolean
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static boolean isSucc(String jsonStr) {
        JSONObject json = JSON.parseObject(jsonStr);
        return isSucc(json);
    }

    /**
     * Description:获取json字符串成功标志码 <br>
     *
     * @param json json
     * @return boolean
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static boolean isSucc(JSONObject json) {
        return ParamConst.RESULT_SUCC == json.getInteger(ParamConst.RES_CODE);
    }

    /**
     * Description: 合并多个jsonobject <br>
     *
     * @param jsons jsons
     * @return json object
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public static JSONObject megerJson(JSONObject... jsons) {
        if (null == jsons) {
            return null;
        }
        JSONObject resultJson = new JSONObject();

        for (JSONObject json : jsons) {
            if (null != json) {
                resultJson.putAll(json);
            }
        }

        return resultJson;
    }
}