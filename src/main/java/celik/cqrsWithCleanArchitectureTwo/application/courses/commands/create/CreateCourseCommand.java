package celik.cqrsWithCleanArchitectureTwo.application.courses.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@Builder
public class CreateCourseCommand {

    @TargetAggregateIdentifier
    private String courseId;

    private String courseName;

    private int totalHours;

}
