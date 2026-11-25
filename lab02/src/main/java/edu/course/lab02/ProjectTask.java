package edu.course.lab02;

import java.util.Objects;

public class ProjectTask {
    private final String id;
    private String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("error");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("error");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("error");
        }
        this.id = id.trim();
        this.title = title.trim();
        this.status = TaskStatus.NEW;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("status must not be null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return status == TaskStatus.DONE;
    }

    public void addEstimatedHours(int additionalHours) {
        if (additionalHours <= 0) {
            throw new IllegalArgumentException("error");
        }
        this.estimatedHours += additionalHours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}