package net.sta.sentrymirror.handler;

import io.sentry.Sentry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalSentryExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {
        // Sentry异常上报
        Sentry.withScope(scope -> {
            scope.setTag("request-url", request.getRequestURI() != null ? request.getRequestURI() : "unknown");
            Sentry.captureException(ex);
        });

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("系统异常");
    }
}
