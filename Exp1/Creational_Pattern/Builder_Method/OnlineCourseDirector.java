import java.util.Arrays;

public class OnlineCourseDirector {
    public static Course createFullCourse() {
        return new Course.CourseBuilder("Java Programming")
                .addModules(Arrays.asList("Basics", "OOP", "Advanced Topics"))
                .addQuizzes(Arrays.asList("Quiz 1", "Quiz 2"))
                .addAssignments(Arrays.asList("Assignment 1", "Assignment 2"))
                .enableCertificate(true)
                .build();
    }
    

    public static Course createModuleOnlyCourse() {
        return new Course.CourseBuilder("Python Basics")
                .addModules(Arrays.asList("Variables", "Loops", "Functions"))
                .build();
    }
}
