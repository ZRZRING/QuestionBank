package ldu.questionbank.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能: 接口统一返回包装类
 * 作者: Zhouzw
 * 日期: 2024/11/28 09:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_AUTH_ERROR = "401";
    public static final String CODE_SYS_ERROR = "500";

    /**
     * 请求返回编码 200 401 500
     * 编码表示这次请求是成功还是失败
     * 或者说可以看出失败的类型是什么
     */
    private String code;
    /**
     * msg 表示错误的详细信息
     */
    private String msg;
    /**
     * 数据从什么地方返回出去 ？
     * 就是这个data
     * User Object 类型就是 User
     * List Object 类型就是 List
     * Map Object 类就是 Map
     */
    private Object data;

    public static Result success() {
        return new Result(CODE_SUCCESS,"请求成功",null);
    }

    public static Result success(Object data) {
        return new Result(CODE_SUCCESS,"请求成功",data);
    }

    public static Result error(String msg) {
        return new Result(CODE_SYS_ERROR,msg,null);
    }

    public static Result error(String code,String msg) {
        return new Result(code,msg,null);
    }

    public static Result error(){
        return new Result(CODE_SYS_ERROR,"系统错误",null);
    }

}
