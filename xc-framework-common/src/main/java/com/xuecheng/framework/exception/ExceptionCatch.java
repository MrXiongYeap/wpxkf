package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常捕获类
 *
 * @Author:Mr.XiongKF
 * @Date:2019/4/20 20:59
 * Study well and make progress every day.
 */
@ControllerAdvice//控制器增强
@ResponseBody
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);
    //配置异常类型所对应的的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTION;
    //构建ImmutableMap(不能更改)
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();
    //可预知异常
    @ExceptionHandler(CustomException.class)
    public ResponseResult customException(CustomException customException) {
        //记录日志
        LOGGER.error("catch exception:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }
    //不可预知异常
    @ExceptionHandler(Exception.class)
    public ResponseResult exception(Exception exception) {
        //记录日志
        LOGGER.error("catch exception:{}", exception.getMessage());
        if (EXCEPTION == null) {
            EXCEPTION = builder.build();
        }
        ResultCode resultCode = EXCEPTION.get(exception.getClass());
        if (resultCode!=null){
            return new ResponseResult(resultCode);
        }else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }
    static {
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALLD_PARAM);
    }
}
