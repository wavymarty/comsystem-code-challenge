package com.comsystem.homework;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.comsystem.homework.robot.RobotOperations;

import java.util.Arrays;
import java.util.List;

public class RobotOperationsTest {
    private final RobotOperations robotOperations = new RobotOperations();

    @Test
    public void testExcavateStonesForDays() {
        int days = 5;
        RobotPlan expectedPlan = new RobotPlan(days, days, List.of(RobotAction.DIG, RobotAction.DIG, RobotAction.DIG, RobotAction.DIG, RobotAction.DIG));
        RobotPlan actualPlan = robotOperations.excavateStonesForDays(days);
        assertEquals(expectedPlan, actualPlan);
    }

    @Test
    void testDaysRequiredToCollectStones() {
        RobotOperations robotOperations = new RobotOperations();
        RobotPlan expected = new RobotPlan(3, 0, Arrays.asList(RobotAction.CLONE, RobotAction.CLONE, RobotAction.DIG));
        RobotPlan actual = robotOperations.daysRequiredToCollectStones(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testDaysRequiredToCollectStonesWithNegativeNumberOfStones() {
        int numberOfStones = -5;
        assertThrows(IllegalArgumentException.class, () -> robotOperations.daysRequiredToCollectStones(numberOfStones));
    }
}