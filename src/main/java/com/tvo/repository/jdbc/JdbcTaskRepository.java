package com.tvo.repository.jdbc;

import com.tvo.exception.TaskNotFoundException;
import com.tvo.model.Task;
import com.tvo.model.TaskStatus;
import com.tvo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class JdbcTaskRepository implements TaskRepository {
    private static final BeanPropertyRowMapper<Task> TASK_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Task.class);
    private final NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public List<Task> getAllTasks() {
        String sqlGetAllTasks = """
                SELECT *
                FROM task;
                """;
        return jdbcTemplate.query(sqlGetAllTasks, TASK_ROW_MAPPER);
    }

    @Override
    public Task getTaskById(int id) {
        String sqlGetTaskById = """
                SELECT *
                FROM task
                WHERE id = %s;
                """;
        List<Task> taskList = jdbcTemplate.query(sqlGetTaskById.formatted(id), TASK_ROW_MAPPER);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("There is no task by id " + id);
        }
        return taskList.get(0);
    }

    @Override
    public void addNewTask(Task task) {
        String sqlAddTask = """
                INSERT INTO task(title, description, status) VALUES (:title, :description, :status);
                """;
        jdbcTemplate.update(sqlAddTask, Map.of(
                        "title", task.getTitle(),
                        "description", task.getDescription(),
                        "status", task.getStatus().toString()
                )
        );
    }

    @Override
    public void updateExistingTask(int id, Task task) {
        String sqlUpdateTaskInfo = """
                UPDATE task
                SET title = :title, description = :description, status = :status
                WHERE id  = :id;
                """;
        jdbcTemplate.update(sqlUpdateTaskInfo, Map.of(
                "id", id,
                "title", task.getTitle(),
                "description", task.getDescription(),
                "status", task.getStatus().toString()
        ));
    }

    @Override
    public void deleteTask(int id) {
        String sqlDeleteTask = """
                DELETE FROM task
                WHERE id = :id;
                """;
        jdbcTemplate.update(sqlDeleteTask, Map.of(
                "id", id
        ));
    }

    @Override
    public void updateTaskStatusById(int id, TaskStatus status) {
        String sqlUpdateTaskStatus = """
                UPDATE task
                SET status = :status
                WHERE id = :id;
                """;
        jdbcTemplate.update(sqlUpdateTaskStatus, Map.of(
                "id", id,
                "status", status.toString()
        ));
    }
}
