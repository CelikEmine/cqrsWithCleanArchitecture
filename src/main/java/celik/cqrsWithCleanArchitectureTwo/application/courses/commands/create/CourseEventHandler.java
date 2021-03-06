package celik.cqrsWithCleanArchitectureTwo.application.courses.commands.create;

import celik.cqrsWithCleanArchitectureTwo.domain.Course;
import celik.cqrsWithCleanArchitectureTwo.persistance.CourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseEventHandler {
    private CourseRepository courseRepository;

    @Autowired
    public CourseEventHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @EventHandler
    public void on(CourseCreatedEvent courseCreatedEvent){
        Course course =new Course();
        BeanUtils.copyProperties(courseCreatedEvent,course);

        if(this.courseRepository.existsCourseByCourseName(courseCreatedEvent.getCourseName())){
            throw new RuntimeException("kurs mevcut");
        }

        this.courseRepository.save(course);
    }

}
