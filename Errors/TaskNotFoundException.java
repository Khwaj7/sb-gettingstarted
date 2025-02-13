package fr.khj.gettingstarted.Errors;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super("Could not find task: " + message);
    }
}
