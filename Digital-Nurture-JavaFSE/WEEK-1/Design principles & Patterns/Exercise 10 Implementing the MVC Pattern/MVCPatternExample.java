public class MVCPatternExample {
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
          return name; 
          
        }
        public int getId() {
          return id; 
          
        }
        public String getGrade() { 
          return grade;
          }

        public void setName(String name) { 
          this.name = name; 
          
        }
        public void setGrade(String grade) { 
          this.grade = grade; 
          
        }
    }

    static class StudentView {
        public void displayStudentDetails(String name, int id, String grade) {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    static class StudentController {
        private Student model;
        private StudentView view;

        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void setStudentName(String name) {
            model.setName(name);
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    public static void main(String[] args) {
        Student model = new Student("Pradyun", 02, "O");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
