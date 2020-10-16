package com.cp.dd.schedule.task;

import com.cp.dd.schedule.model.ITask;
import com.cp.dd.schedule.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * 订单相关定时器
 */
@AllArgsConstructor
@Component
public class MealOrderTask implements ITask {




    @Task(desc = "测试定时器", time = "每分钟执行一次")
    @Scheduled(cron = "0 */1 * * * ?")
    public void cancelOrder() {
        System.out.println("11");
    }
}
