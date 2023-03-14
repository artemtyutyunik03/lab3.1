import java.util.Random;
import java.util.Date;
import java.util.function.Consumer;

class main {
    public static void main(String[] args) {
        Student student1 = new Student("Петрик", "Нестор", 121178, "2022-03-10");
        Student student2 = new Student("Колесник", "Дан", 121127, "2022-03-10");
        Student student3 = new Student("Блохин", "Бронислав", 121989, "2022-03-10");
        Student student4 = new Student("Хижняк", "Артемий", 121121, "2022-03-10");
        BinaryTree newBinaryTree = new BinaryTree();
        newBinaryTree.add(student1);
        newBinaryTree.add(student2);
        newBinaryTree.add(student3);
        newBinaryTree.add(student4);
        newBinaryTree.print();
    }

    public static class Student {
        String Surname;
        String Name;
        int Stud_ID;
        String BirthdayDate;

        Student (String Surname, String Name, int Stud_ID, String BirthdayDate){
            this.Surname = Surname;
            this.Name = Name;
            this.Stud_ID = Stud_ID;
            this.BirthdayDate = BirthdayDate;
        }
        public String toString() {
            return String.format("Surname: %s, Name: %s, ID: %d, Date of Birth: %s",
                    Surname, Name, Stud_ID, BirthdayDate);
        }
    }

    public static class BinaryTree {
        class Node {
            Student data;
            Node right;
            Node left;
            Node(Student data) {
                this.data = data;
            }
        }
        private Node root;
        public BinaryTree() {
            root = null;
        }
        public void add(Student student) {
            root = insert(root, student);
        }
        private Node insert(Node current, Student student) {
            if (current == null) {
                return new Node(student);
            } else {
                if (student.Stud_ID < current.data.Stud_ID) {
                    current.left = insert(current.left, student);
                } else if (student.Stud_ID > current.data.Stud_ID) {
                    current.right = insert(current.right, student);
                }
            }
            return current;
        }
        public void print (){
            postOrder(root);
        }

        private void postOrder (Node current){
            if(current == null){
                return;
            }
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data.toString());

        }
    }
}






