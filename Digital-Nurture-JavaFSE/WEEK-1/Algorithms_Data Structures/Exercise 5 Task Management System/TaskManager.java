public class TaskManager {
    static class Task {
        int taskId;
        String taskName;
        String status;
        Task next;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        void display() {
            System.out.println(taskId + " - " + taskName + " - " + status);
        }
    }

    static class TaskList {
        Task head;

        void add(Task task) {
            if (head == null) head = task;
            else {
                Task temp = head;
                while (temp.next != null) temp = temp.next;
                temp.next = task;
            }
        }

        Task search(int id) {
            Task temp = head;
            while (temp != null) {
                if (temp.taskId == id) return temp;
                temp = temp.next;
            }
            return null;
        }

        void delete(int id) {
            if (head == null) return;
            if (head.taskId == id) {
                head = head.next;
                return;
            }
            Task prev = head;
            Task curr = head.next;
            while (curr != null) {
                if (curr.taskId == id) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        void traverse() {
            Task temp = head;
            while (temp != null) {
                temp.display();
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.add(new Task(1, "Design DB", "Pending"));
        list.add(new Task(2, "Build API", "In Progress"));
        list.traverse();
        System.out.println("Searching for Task 2:");
        Task t = list.search(2);
        if (t != null) t.display();
        System.out.println("Deleting Task 1-Remaining Tasks:");
        list.delete(1);
         
        list.traverse();
    }
}
