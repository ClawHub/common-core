package com.clawhub.util.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <Description> 返回结果封装< <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月05日<br>
 */
public class ResultInfo<E> {

    /**
     * 是否成功
     */
    private int resCode;

    /**
     * 结果消息
     */
    private List<RtnMessage> resMsg;

    /**
     * 返回信息
     */
    private E resData;

    /**
     * Description: 构造
     * 
     * @param resCode <br>
     * @param resMsg <br>
     * @param resData <br>
     */
    public ResultInfo(int resCode, List<RtnMessage> resMsg, E resData) {
        super();
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.resData = resData;
    }

    /**
     * Description: 构造
     * 
     * @param resCode <br>
     * @param resMsg <br>
     */
    @SuppressWarnings("unchecked")
    public ResultInfo(int resCode, List<RtnMessage> resMsg) {
        super();
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.resData = (E) new Object();
    }

    /**
     * Description: 构造
     * 
     * @param resCode <br>
     * @param resData <br>
     */
    public ResultInfo(int resCode, E resData) {
        super();
        this.resCode = resCode;
        this.resMsg = new ArrayList<RtnMessage>();
        this.resData = resData;
    }

    /**
     * Description: 构造
     * 
     * @param resCode <br>
     * @param rtnMsg <br>
     */
    @SuppressWarnings("unchecked")
    public ResultInfo(int resCode, RtnMessage rtnMsg) {
        super();
        this.resCode = resCode;
        this.resMsg = Arrays.asList(new RtnMessage[] {
                rtnMsg
        });
        this.resData = (E) new Object();
    }

    /**
     * 构造
     * 
     * @param result 返回结果
     * @param rtnMsg 返回提示信息
     * @param resData 返回数据
     */
    public ResultInfo(int result, RtnMessage rtnMsg, E resData) {
        super();
        this.resCode = result;
        this.resMsg = Arrays.asList(new RtnMessage[] {
                rtnMsg
        });
        this.resData = resData;
    }

    /**
     * get resCode
     * 
     * @return Returns the resCode.<br>
     */
    public int getResCode() {
        return resCode;
    }

    /**
     * set resCode
     * 
     * @param resCode The resCode to set. <br>
     */
    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    /**
     * get resMsg
     * 
     * @return Returns the resMsg.<br>
     */
    public List<RtnMessage> getResMsg() {
        return resMsg;
    }

    /**
     * set resMsg
     * 
     * @param resMsg The resMsg to set. <br>
     */
    public void setResMsg(List<RtnMessage> resMsg) {
        this.resMsg = resMsg;
    }

    /**
     * get resData
     * 
     * @return Returns the resData.<br>
     */
    public E getResData() {
        return resData;
    }

    /**
     * set resData
     * 
     * @param resData The resData to set. <br>
     */
    public void setResData(E resData) {
        this.resData = resData;
    }

}
