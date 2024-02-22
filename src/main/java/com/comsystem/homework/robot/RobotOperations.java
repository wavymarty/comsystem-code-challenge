package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.model.RobotAction;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>maximizing</em> the number of stones that the robot will dig.
     */
    public RobotPlan excavateStonesForDays(int days) {
        List<RobotAction> actions = new ArrayList<>();
        int stones = 0;

        for (int i = 0; i < days; i++) {
            actions.add(RobotAction.DIG);
            stones++;
        }

        return new RobotPlan(days, stones, actions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>minimizing</em> the number of days necessary for the robot to dig the
     * provided number of stones.
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        if (numberOfStones <= 0) {
            throw new IllegalArgumentException("Number of stones must be positive.");
        }

        int days = 0;
        int minDays = 0;
        List<RobotAction> actions = new ArrayList<>();

        while (numberOfStones > 0) {
            if (numberOfStones >= 2) {
                actions.add(RobotAction.CLONE);
                numberOfStones -= 2;
                days += 1;
            } else {
                actions.add(RobotAction.DIG);
                numberOfStones--;
                days += 1;
            }

            if (days > minDays) {
                minDays = days;
            }
        }

        return new RobotPlan(minDays, 0, actions);
    }
}