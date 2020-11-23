package com.timelogr.enterprise;

import com.timelogr.enterprise.dto.TimeLog;
import com.timelogr.enterprise.service.TimeLogrService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    private TimeLogrService timeLogrService;
    private final TimeLog timeLog = new TimeLog();

    @Test
    void contextLoads() {
    }

    @Test
    void saveNewTimeLog() {
        timeLog.setDate(10182020);
        timeLog.setDuration(742);
        timeLog.setId(3);
        TimeLog newTimeLog = timeLogrService.saveLog(timeLog);
    }

    @Test
    void viewAllLoggedTime() {

    }


}
