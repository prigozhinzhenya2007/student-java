package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTaskTest {

    @Test
    void createsTaskWithValidDataAndTrimmedStrings() {
        ProjectTask task = new ProjectTask("  T-1  ", "  Implement encapsulation  ", 6);

        assertEquals("T-1", task.getId());
        assertEquals("Implement encapsulation", task.getTitle());
        assertEquals(TaskStatus.NEW, task.getStatus());
        assertEquals(6, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void throwsOnBlankOrNullId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Task", 4));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Task", 4));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("   ", "Task", 4));
    }

    @Test
    void throwsOnBlankOrNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", null, 4));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "", 4));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "   ", 4));
    }

    @Test
    void throwsOnNonPositiveInitialEstimatedHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Task", 0));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Task", -3));
    }

    @Test
    void changesStatusAndMarksCompletedOnlyWhenDone() {
        ProjectTask task = new ProjectTask("T-1", "Task", 4);

        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertFalse(task.isCompleted());

        task.changeStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isCompleted());
    }

    @Test
    void throwsWhenChangingStatusToNull() {
        ProjectTask task = new ProjectTask("T-1", "Task", 4);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }

    @Test
    void addsPositiveEstimatedHours() {
        ProjectTask task = new ProjectTask("T-1", "Task", 4);
        task.addEstimatedHours(5);
        assertEquals(9, task.getEstimatedHours());
    }

    @Test
    void throwsWhenAddingZeroOrNegativeHours() {
        ProjectTask task = new ProjectTask("T-1", "Task", 4);
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(0));
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(-2));
    }

    @Test
    void keepsStatusAndHoursWhenInvalidChangeAttempted() {
        ProjectTask task = new ProjectTask("T-1", "Task", 4);
        task.changeStatus(TaskStatus.IN_PROGRESS);

        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(0));
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(-2));

        assertEquals("T-1", task.getId());
        assertEquals("Task", task.getTitle());
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertEquals(4, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }
}