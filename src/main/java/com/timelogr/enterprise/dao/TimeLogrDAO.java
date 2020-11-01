package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.TimeLog;

import java.util.List;

public interface TimeLogrDAO {

    TimeLog save(TimeLog timeLog);

    List<TimeLog> getAllLoggedTime();
}
