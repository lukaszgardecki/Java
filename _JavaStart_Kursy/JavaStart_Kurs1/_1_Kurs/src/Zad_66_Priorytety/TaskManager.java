package Zad_66_Priorytety;

import java.util.PriorityQueue;
import java.util.Queue;

class TaskManager {
    private Queue<Task> tasks = new PriorityQueue<>();

    void add(Task task) {
        tasks.offer(task);
    }

    Task getNextTask() {
        return tasks.poll();
    }



    public String getTasksPriorityNames() {
        StringBuilder sb = new StringBuilder();
        for (Task.Priority priority : Task.Priority.values()) {
            sb.append(priority).append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
