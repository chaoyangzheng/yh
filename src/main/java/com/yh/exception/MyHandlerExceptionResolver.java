package com.yh.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author yuanzhe
 * @date 2019/9/30
 */
@RestControllerAdvice
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {


    private static final Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.info("我是info级别的异常");
        logger.debug("我是debug级别的异常");
        //控制台打印异常
        e.printStackTrace();
        //向日志文件中写入异常
        logger.error("发生异常了..",e);
        //展示错误页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","网络故障，请稍后再试试吧！");
        modelAndView.setViewName("error/exception");
        return modelAndView;
    }
}
