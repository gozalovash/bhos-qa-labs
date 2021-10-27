public class Hogwarts {
    static String faculty;

    private static void setFaculty(){
        faculty = "Gryffindor";
    }
    private static String getFaculty(){
        return faculty;
    }

    public static void main(String[] args) {
        setFaculty();
        System.out.println(getFaculty());
    }
}
