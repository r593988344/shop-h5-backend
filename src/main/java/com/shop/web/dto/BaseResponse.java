package com.shop.web.dto;

import com.shop.web.enums.ConstantEnums;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class BaseResponse<T> {


    private static final String SUCCESS = "success";

    private static final String ERROR = "error";


    /**
     * 响应状态码 0为正常,大于0是业务异常，小于0是系统级异常
     */
    private Integer code;


    /**
     * 携带的消息
     */
    private String msg;

    /**
     * 携带的数据
     */
    private T data;


    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public BaseResponse(T data) {
        this.data = data;
        this.msg = "SUCCESS";
        this.code = 0;
    }

    public static BaseResponse BaseResponseCreateOk() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("SUCCESS");
        return baseResponse;
    }

    /**
     * 错误响应
     *
     * @param constantEnums
     * @return
     */
    public static BaseResponse createError(ConstantEnums constantEnums) {
        return new BaseResponse(constantEnums.getCode(), constantEnums.getMsg(), null);
    }

    /**
     * 错误响应
     *
     * @param constantEnums
     * @return
     */
    public static BaseResponse createErrorWithReason(ConstantEnums constantEnums, String reason) {
        return new BaseResponse(constantEnums.getCode(), String.format(constantEnums.getMsg(), reason), null);
    }

}
