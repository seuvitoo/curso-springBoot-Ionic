package br.dev.seuvito.backendloja.controllers.execption;

import java.io.Serializable;

public class AppError implements Serializable {

    private static final long serialVersionUID = 1l;

    private Integer status;
    private String msg;
    private Long timeStamp;


    public AppError() {
    }

    public AppError(Integer status, String msg, Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
