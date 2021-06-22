package com.project.sbb_nau.controller;

import com.project.sbb_nau.config.dto.StationDto;
import com.project.sbb_nau.entity.Schedule;
import com.project.sbb_nau.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:8081")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<Schedule> getStationSchedule(@RequestBody StationDto stationDto) {
        return scheduleService.findByStationId(stationDto.getId());
    }
}
