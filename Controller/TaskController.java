package fr.khj.gettingstarted.Controller;

import fr.khj.gettingstarted.Errors.TaskNotFoundException;
import fr.khj.gettingstarted.model.TaskEntity;
import fr.khj.gettingstarted.repository.TaskRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public TaskEntity getTaskById(@RequestParam Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id.toString()));
    }

    @PutMapping("/tasks/{id}")
    public TaskEntity updateTask(@PathVariable Long id, @RequestBody TaskEntity updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            return taskRepository.save(task);
        }).orElseGet(() -> taskRepository.save(updatedTask));
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
