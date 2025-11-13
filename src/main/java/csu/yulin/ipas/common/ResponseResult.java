package csu.yulin.ipas.common;

import lombok.Data;

/**
 * @author lp
 */
@Data
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    // 成功
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    // 失败
    public static <T> ResponseResult<T> error(int code, String message) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static <T> ResponseResult<T> error(int code, String message, T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}