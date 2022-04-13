package celik.cqrsWithCleanArchitectureTwo.persistance;

import celik.cqrsWithCleanArchitectureTwo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course,String> {
    boolean existsCourseByCourseName(String name);
}
