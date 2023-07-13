package kr.re.kitri.springpost.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.postgresql.util.PSQLException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice // 예외처리 전용 컴포넌트로 등록해주는 어노테이션
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = TooManyResultsException.class)
    public static ErrorResponse handleException(TooManyResultsException e) {
        log.error("Too Many Result Exception 발생 : ... " + e.getMessage());
        //return "데이터가 너무 많다.";
        return new ErrorResponse(
                "조회 결과가 너무 많습니다.",
                "400"
        );
    }

//    @ExceptionHandler(value = PSQLException.class)
//    public static ErrorResponse psqlException(PSQLException e) {
//        log.error("Too Many Result Exception 발생 : ... " + e.getMessage());
//        //return "데이터가 너무 많다.";
//        return new ErrorResponse(
//                "데이터베이스 오류가 발생했습니다.",
//                "500");
//    }

        @ExceptionHandler(value = BadSqlGrammarException.class)
    public static ErrorResponse badsqlException(BadSqlGrammarException e) {
        log.error("SQL 관련 오류 발생 : ... " + e.getMessage());
        return new ErrorResponse(
                "데이터베이스 오류가 발생했습니다.",
                "500"
        );
    }

    @ExceptionHandler(value = Exception.class)
    public static ErrorResponse exception(Exception e) {
        log.error("이유를 알 수 없는 오류 발생 : ... " + e.getMessage());
        //return "데이터가 너무 많다.";
        return new ErrorResponse(
                "데이터베이스 오류가 발생했습니다.",
                "500"
        );
    }
}
