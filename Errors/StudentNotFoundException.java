package fr.khj.gettingstarted.Errors;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long message) {
        super("Couldn't find student " + message);
    }
}
