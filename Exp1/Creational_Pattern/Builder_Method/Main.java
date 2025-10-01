public class Main {
    public static void main(String[] args) {
        try {
            Course fullCourse = OnlineCourseDirector.createFullCourse();
            Course moduleOnlyCourse = OnlineCourseDirector.createModuleOnlyCourse();

            System.out.println("       Full Course     ");
            System.out.println(fullCourse);

            System.out.println("\n    Module Only Course    ");
            System.out.println(moduleOnlyCourse);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

