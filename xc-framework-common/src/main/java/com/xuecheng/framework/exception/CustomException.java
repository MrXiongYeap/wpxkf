package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * 自定义异常类型
 * @Author:Mr.XiongKF
 * @Date:2019/4/20 20:14
 * Study well and make progress every day.
 */
public class CustomException extends RuntimeException {
    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode=resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }
}
