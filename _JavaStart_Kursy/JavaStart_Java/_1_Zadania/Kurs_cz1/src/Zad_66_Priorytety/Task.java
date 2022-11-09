package Zad_66_Priorytety;

class Task implements Comparable<Task>{
    private String name;
    private String description;
    private Priority priority;

    public Task(String name, Priority priority, String description) {
        this.name = name;
        this.priority = priority;
        this.description = description;
    }

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task t) {
        return -Integer.compare(priority.value, t.priority.value);
    }

    @Override
    public String toString() {
        if (description != null) {
            return String.format("%s (%s)%n", name, description);
        }
        return name;
    }

    enum Priority {
        LOW(1),
        MODERATE(2),
        HIGH(3);

        private int value;

        Priority(int value) {
            this.value = value;
        }
    }
}

