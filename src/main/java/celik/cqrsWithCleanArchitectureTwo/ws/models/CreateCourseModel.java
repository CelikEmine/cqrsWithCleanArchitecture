package celik.cqrsWithCleanArchitectureTwo.ws.models;

import lombok.Data;

@Data
public class CreateCourseModel {

    private String courseName;
    private int totalHours;

}
