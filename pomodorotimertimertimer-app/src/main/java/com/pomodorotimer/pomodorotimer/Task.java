package com.pomodorotimer.pomodorotimer;

/**
 * Task class representing a work task in Pomodoro Timer.
 * Used with various data structures for task management.
 * 
 * @author Data Structures Project Team
 * @version 1.0
 */
public class Task {
    private String id;
    private String name;
    private String description;
    private int priority; // Lower number = higher priority
    private int estimatedPomodoros;
    private int completedPomodoros;
    private TaskStatus status;
    
    public enum TaskStatus {
        TODO, IN_PROGRESS, COMPLETED, CANCELLED
    }
    
    public Task(String id, String name, String description, int priority, int estimatedPomodoros) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.estimatedPomodoros = estimatedPomodoros;
        this.completedPomodoros = 0;
        this.status = TaskStatus.TODO;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public int getEstimatedPomodoros() { return estimatedPomodoros; }
    public int getCompletedPomodoros() { return completedPomodoros; }
    public TaskStatus getStatus() { return status; }
    
    public void setStatus(TaskStatus status) { this.status = status; }
    public void incrementCompletedPomodoros() { this.completedPomodoros++; }
    
    @Override
    public String toString() {
        return String.format("%s (Priority: %d, Pomodoros: %d/%d)", name, priority, completedPomodoros, estimatedPomodoros);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id != null ? id.equals(task.id) : task.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

