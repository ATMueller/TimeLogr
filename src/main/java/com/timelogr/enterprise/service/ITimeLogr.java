package com.timelogr.enterprise.service;
import java.util.List;
import com.timelogr.enterprise.dto.employee;

public interface ITimeLogr {
    public List<employee> GetAllEmployees();
}
