package taskManagementSystem;

import java.util.concurrent.atomic.AtomicInteger;

class Task {

    enum PRIORITY {
        LOW, MEDIUM, HIGH
    }

    private static final AtomicInteger  count = new AtomicInteger(0);
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private PRIORITY priority;

    Task(String title, String description, PRIORITY priority) {
        this.title = title;
        this.id = count.incrementAndGet();
        this.description = description;
        this.completed = false;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public PRIORITY getPriority() {
        return priority;
    }

    public void setPriority(PRIORITY priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
                + ", priority=" + priority + "]";
    }

    public String toFileString(){
        return this.getId() + "|" + this.getTitle() + "|" + this.getDescription() + "|" + this.isCompleted() + "|" + this.getPriority() + "\n";
    }

}
