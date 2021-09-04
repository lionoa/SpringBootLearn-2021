package springboot.springbootlearn2021.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.springbootlearn2021.comment.Result;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result<String> exception(Exception e) {
        if (e instanceof DuplicateKeyException) {
            return Result.error("已有该用户，请勿重复注册！", e.getMessage());
        }
        if (e instanceof BadCredentialsException) {
            return Result.error("用户名或密码错误", e.getMessage());
        }
        return Result.error("未知错误，请联系管理员！", e.getMessage());
    }
}
