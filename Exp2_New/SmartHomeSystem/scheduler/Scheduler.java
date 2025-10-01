package scheduler;

import java.util.*;

public class Scheduler {
    private List<String> tasks = new ArrayList<>();

    public void addTask(int deviceId, String time, String command) {
        tasks.add("{device: " + deviceId + ", time: " + time + ", command: " + command + "}");
    }

    public void showTasks() {
        System.out.println("Scheduled Tasks: " + tasks);
    }
}
