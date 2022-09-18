package com.example.tech_webclient_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@Slf4j
@RestController
public class DelayController {

    @GetMapping("/delay/{time}")
    public ResponseEntity<?> call(HttpServletRequest request, @PathVariable int time) throws InterruptedException {
        log.info("-----------------START---------------");
        log.info("listen : {}", LocalDateTime.now());
        log.info("path: {}", request.getServletPath());
        log.info("thread name: {} id: {}", Thread.currentThread().getName(), Thread.currentThread().getId());
        log.info("-----------------END---------------");
        Thread.sleep(time);
        return ResponseEntity.ok("성공");
    }
}
