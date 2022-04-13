package celik.cqrsWithCleanArchitectureTwo.application.courses.commands.create;

import lombok.Data;

@Data
public class CourseCreatedEvent {
    private String courseId;

    private String courseName;

    private int totalHours;
}
