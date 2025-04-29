package com.doodl6.code.chaos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpu")
public class CpuController {

    /**
     * 高CPU占用
     */
    @GetMapping("/highUsage")
    public String highUsage(@RequestParam(value = "durationSeconds", required = false) Integer durationSeconds) {
        if (durationSeconds == null) {
            durationSeconds = 30;
        }
        long endTime = System.currentTimeMillis() + (durationSeconds * 1000L);
        while (System.currentTimeMillis() < endTime) {
            // 执行复杂的数学运算
            double result = 0.0;
            for (int i = 0; i < 1000000; i++) {
                result += Math.sin(i) * Math.cos(i);
                result = Math.pow(result, 1.0 + Math.random());
            }

            // 模拟一些字符串操作
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                sb.append(Math.random());
            }
            System.out.println("highUsage sb length:" + sb.length());

            // 避免过于激进的优化
            if (System.currentTimeMillis() % 1000 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
            }
        }

        return "success";
    }
}
