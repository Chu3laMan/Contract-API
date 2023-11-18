package co.chu3la.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {

    public static BaseResponse ofSuccess() {
        BaseResponse success = new BaseResponse();
        success.setStatus(Boolean.TRUE);
        return success;
    }

    public static <T> BaseResponse ofSuccess(T data) {
        BaseResponse success = new BaseResponse();
        success.setStatus(Boolean.TRUE);
        success.setJsonData(data);
        return success;
    }

    public static BaseResponse ofError() {
        BaseResponse error = new BaseResponse();
        error.setStatus(Boolean.FALSE);
        return error;
    }

    public static BaseResponse ofError(String msg) {
        BaseResponse error = new BaseResponse();
        error.setStatus(Boolean.FALSE);
        error.setMsg(msg);
        return error;
    }

    public static BaseResponse ofError(String msg, String statusCode) {
        BaseResponse error = new BaseResponse();
        error.setStatus(Boolean.FALSE);
        error.setMsg(msg);
        error.setStatusCode(statusCode);
        return error;
    }

    private Boolean status;

    private String msg;

    private T jsonData;

    private String statusCode;



    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getJsonData() {
        return jsonData;
    }

    public void setJsonData(T jsonData) {
        this.jsonData = jsonData;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
