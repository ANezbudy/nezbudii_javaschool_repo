package com.project.sbb_nau.controller;

import com.project.sbb_nau.config.dto.ScheduleDto;
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

    //check if it is a good endpoint
    @GetMapping("/station/schedules")
    public List<Schedule> getStationSchedule(@RequestParam int id) {
        return scheduleService.findByStationId(id);
    }

    //check if it is a good endpoint
    @GetMapping("/schedules")
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PostMapping("/schedules/create")
    public String createSchedule(@RequestBody ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setArrivalTime(scheduleDto.getArrivalTime());
        schedule.setDepartureTime(scheduleDto.getDepartureTime());
        scheduleService.saveSchedule(schedule, scheduleDto.getStation().getId(), scheduleDto.getTrain().getId());
        return "Schedule created";
    }

    @PutMapping("/schedule/update")
    public String updateSchedule(@RequestBody ScheduleDto scheduleDto) {
        Schedule schedule = scheduleService.getSchedule(scheduleDto.getId());
        schedule.setArrivalTime(scheduleDto.getArrivalTime());
        schedule.setDepartureTime(scheduleDto.getDepartureTime());
        //TODO change to handle exactly the update - train can be changed not the station
        scheduleService.saveSchedule(schedule, scheduleDto.getStation().getId(), scheduleDto.getTrain().getId());
        return "Schedule update";
    }

    @DeleteMapping("/schedule/delete")
    public String deleteSchedule(@RequestBody ScheduleDto scheduleDto) {
        scheduleService.deleteSchedule(scheduleDto.getId());
        return "Station deleted";
    }
}
