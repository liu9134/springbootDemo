package com.lcl.demo3.model;

/**
 * @author liuchonglong
 * @version V1.0
 * @Description: TODO
 * @date 2018/8/27 17:54
 */
public class ResultModel {
    private int code;
    private String msg;
    private Object result;

    public ResultModel(){
        super();
    }

    public ResultModel(int code,String msg){
        this.code = code;
        this.msg = msg;
        this.result = "";
    }

    public ResultModel(int code,String msg,Object result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
