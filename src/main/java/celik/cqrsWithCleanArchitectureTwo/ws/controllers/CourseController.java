package celik.cqrsWithCleanArchitectureTwo.ws.controllers;

import celik.cqrsWithCleanArchitectureTwo.application.accountTypes.commands.create.CreateAccountTypeCommand;
import celik.cqrsWithCleanArchitectureTwo.application.courses.commands.create.CreateCourseCommand;
import celik.cqrsWithCleanArchitectureTwo.ws.models.CreateAccountTypeModel;
import celik.cqrsWithCleanArchitectureTwo.ws.models.CreateCourseModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CommandGateway commandGateway;

    public CourseController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("add")
    public void add(@RequestBody CreateCourseModel createCourseModel){

        CreateCourseCommand command=CreateCourseCommand.builder()
                        .courseName(createCourseModel.getCourseName())
                        .totalHours(createCourseModel.getTotalHours())
                        .build();


        command.setCourseId(UUID.randomUUID().toString());
        this.commandGateway.sendAndWait(command);
    }


}
