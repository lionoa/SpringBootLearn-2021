package springboot.springbootlearn2021.comment;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class Result<T> {

    private static final long serialVersionUID = -8713837118340960775L;

    /** 成功*/
    private static final Integer SUCCESS = 200;
    /** 警告*/
    private static final Integer WARN = 4001;
    /** 异常 失败*/
    private static final Integer FAIL = 4002;

    private Integer code;

    private String msg;

    private Object data;

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 失败并返回数据
     * @param data
     * @return
     */
    public static <T> Result<T> error(T data) {
        return new Result<>(FAIL, data);
    }

    /**
     * 失败并返回信息及数据
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(FAIL, msg, data);
    }

    /**
     * 警告并返回数据
     * @param data
     * @return
     */
    public static <T> Result<T> warn(Object data) {
        return new Result<>(WARN, data);
    }

    /**
     * 成功并返回数据
     * @param msg
     * @param data
     * @return
     */
    public static <T> Result<T> ok(String msg, Object data) {
        return new Result<>(SUCCESS, msg, data);
    }

    /**
     * 带数据
     * @param data
     * @return
     */
    public static <T> Result<T> ok(Object data) {
        return new Result<>(SUCCESS,"操作成功",data);
    }

    /**
     * 成功返回通用数据
     * @return
     */
    public static <T> Result<T> ok() {
        return new Result<>(SUCCESS, "操作成功");
    }

}