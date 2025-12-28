package com.pomodorotimer.pomodorotimer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Task class.
 * Tests task creation, status management, and pomodoro tracking.
 */
@DisplayName("Task Tests")
class TaskTest {
    
    @Test
    @DisplayName("Test task creation with all parameters")
    void testTaskCreation() {
        Task task = new Task("T1", "Test Task", "Description", 1, 3);
        
        assertEquals("T1", task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("Description", task.getDescription());
        assertEquals(1, task.getPriority());
        assertEquals(3, task.getEstimatedPomodoros());
        assertEquals(0, task.getCompletedPomodoros());
        assertEquals(Task.TaskStatus.TODO, task.getStatus());
    }
    
    @Test
    @DisplayName("Test task status changes")
    void testTaskStatusChanges() {
        Task task = new Task("T1", "Test Task", "Description", 1, 3);
        
        assertEquals(Task.TaskStatus.TODO, task.getStatus());
        
        task.setStatus(Task.TaskStatus.IN_PROGRESS);
        assertEquals(Task.TaskStatus.IN_PROGRESS, task.getStatus());
        
        task.setStatus(Task.TaskStatus.COMPLETED);
        assertEquals(Task.TaskStatus.COMPLETED, task.getStatus());
        
        task.setStatus(Task.TaskStatus.CANCELLED);
        assertEquals(Task.TaskStatus.CANCELLED, task.getStatus());
    }
    
    @Test
    @DisplayName("Test increment completed pomodoros")
    void testIncrementCompletedPomodoros() {
        Task task = new Task("T1", "Test Task", "Description", 1, 3);
        
        assertEquals(0, task.getCompletedPomodoros());
        
        task.incrementCompletedPomodoros();
        assertEquals(1, task.getCompletedPomodoros());
        
        task.incrementCompletedPomodoros();
        assertEquals(2, task.getCompletedPomodoros());
        
        task.incrementCompletedPomodoros();
        assertEquals(3, task.getCompletedPomodoros());
    }
    
    @Test
    @DisplayName("Test toString method")
    void testToString() {
        Task task = new Task("T1", "Test Task", "Description", 5, 4);
        String result = task.toString();
        
        assertTrue(result.contains("Test Task"));
        assertTrue(result.contains("Priority: 5"));
        assertTrue(result.contains("0/4"));
        
        task.incrementCompletedPomodoros();
        task.incrementCompletedPomodoros();
        result = task.toString();
        assertTrue(result.contains("2/4"));
    }
    
    @Test
    @DisplayName("Test equals method")
    void testEquals() {
        Task task1 = new Task("T1", "Task 1", "Desc 1", 1, 2);
        Task task2 = new Task("T1", "Task 2", "Desc 2", 3, 4);
        Task task3 = new Task("T2", "Task 1", "Desc 1", 1, 2);
        Task task4 = new Task("T1", "Task 1", "Desc 1", 1, 2);
        
        // Same ID should be equal
        assertEquals(task1, task2);
        assertEquals(task1, task4);
        
        // Different ID should not be equal
        assertNotEquals(task1, task3);
        
        // Same object
        assertEquals(task1, task1);
        
        // Null
        assertNotEquals(task1, null);
        
        // Different type
        assertNotEquals(task1, "not a task");
    }
    
    @Test
    @DisplayName("Test hashCode method")
    void testHashCode() {
        Task task1 = new Task("T1", "Task 1", "Desc 1", 1, 2);
        Task task2 = new Task("T1", "Task 2", "Desc 2", 3, 4);
        Task task3 = new Task("T2", "Task 1", "Desc 1", 1, 2);
        
        // Same ID should have same hash code
        assertEquals(task1.hashCode(), task2.hashCode());
        
        // Different ID might have different hash code (not guaranteed but likely)
        // Just check that it doesn't throw exception
        assertNotNull(task3.hashCode());
    }
    
    @Test
    @DisplayName("Test task with null ID")
    void testTaskWithNullId() {
        Task task = new Task(null, "Test", "Desc", 1, 2);
        assertNull(task.getId());
        assertEquals(0, task.hashCode());
    }
    
    @Test
    @DisplayName("Test all TaskStatus enum values")
    void testTaskStatusEnum() {
        Task.TaskStatus[] statuses = Task.TaskStatus.values();
        assertEquals(4, statuses.length);
        
        assertTrue(contains(statuses, Task.TaskStatus.TODO));
        assertTrue(contains(statuses, Task.TaskStatus.IN_PROGRESS));
        assertTrue(contains(statuses, Task.TaskStatus.COMPLETED));
        assertTrue(contains(statuses, Task.TaskStatus.CANCELLED));
    }
    
    @Test
    @DisplayName("Test getter methods")
    void testGetters() {
        Task task = new Task("T1", "Name", "Desc", 5, 10);
        
        assertEquals("T1", task.getId());
        assertEquals("Name", task.getName());
        assertEquals("Desc", task.getDescription());
        assertEquals(5, task.getPriority());
        assertEquals(10, task.getEstimatedPomodoros());
        assertEquals(0, task.getCompletedPomodoros());
        assertEquals(Task.TaskStatus.TODO, task.getStatus());
    }
    
    @Test
    @DisplayName("Test task with zero estimated pomodoros")
    void testTaskWithZeroPomodoros() {
        Task task = new Task("T1", "Test", "Desc", 1, 0);
        assertEquals(0, task.getEstimatedPomodoros());
        assertEquals(0, task.getCompletedPomodoros());
    }
    
    @Test
    @DisplayName("Test task with high priority")
    void testTaskWithHighPriority() {
        Task task = new Task("T1", "Test", "Desc", 1, 3);
        assertEquals(1, task.getPriority());
        
        // Lower number = higher priority
        Task lowPriorityTask = new Task("T2", "Test", "Desc", 10, 3);
        assertTrue(task.getPriority() < lowPriorityTask.getPriority());
    }
    
    private boolean contains(Task.TaskStatus[] array, Task.TaskStatus value) {
        for (Task.TaskStatus status : array) {
            if (status == value) {
                return true;
            }
        }
        return false;
    }
}

