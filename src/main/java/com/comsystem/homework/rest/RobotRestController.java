package com.comsystem.homework.rest;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotRestController {

    private final RobotOperations robotOperations;

    public RobotRestController(RobotOperations robotOperations) {
        this.robotOperations = robotOperations;
    }

    @GetMapping("/excavate")
    public RobotPlan excavateStonesForDays(@RequestParam int days) {
        return robotOperations.excavateStonesForDays(days);
    }

    @GetMapping("/collect")
    public RobotPlan daysRequiredToCollectStones(@RequestParam int numberOfStones) {
        return robotOperations.daysRequiredToCollectStones(numberOfStones);
    }
}