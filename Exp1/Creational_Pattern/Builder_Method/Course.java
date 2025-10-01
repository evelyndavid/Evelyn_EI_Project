import java.util.List;

public class Course {
    private final String title;
    private final List<String> modules;
    private final List<String> quizzes;
    private final List<String> assignments;
    private final boolean certificate;

    private Course(CourseBuilder builder) {
        this.title = builder.title;
        this.modules = builder.modules;
        this.quizzes = builder.quizzes;
        this.assignments = builder.assignments;
        this.certificate = builder.certificate;
    }
    

    @Override
    public String toString() {
        return "Course Title: " + title + "\nModules: " + modules + "\nQuizzes: " + quizzes +
                "\nAssignments: " + assignments + "\nCertificate: " + (certificate ? "Yes" : "No");
    }

    public static class CourseBuilder {
        private final String title; // mandatory
        private List<String> modules;
        private List<String> quizzes;
        private List<String> assignments;
        private boolean certificate;

        public CourseBuilder(String title) {
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("Course title cannot be null or empty");
            }
            this.title = title;
        }

        public CourseBuilder addModules(List<String> modules) {
            this.modules = modules;
            return this;
        }

        public CourseBuilder addQuizzes(List<String> quizzes) {
            this.quizzes = quizzes;
            return this;
        }

        public CourseBuilder addAssignments(List<String> assignments) {
            this.assignments = assignments;
            return this;
        }

        public CourseBuilder enableCertificate(boolean certificate) {
            this.certificate = certificate;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}