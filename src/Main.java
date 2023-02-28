import java.util.Random;

public class Main {
    public static void main(String[] args) {
       Demonstrate();
    }

    public static class Dot {
        double X;
        double Y;

        Dot(double X, double Y){
            this.X = X;
            this.Y = Y;
        }

        Dot(){
            Random rand = new Random();
            this.X = rand.nextDouble()*10;
            this.Y = rand.nextDouble()*10;
        }

    }

    public static class Triangle {
        private Dot A,B,C;
        private double AB, AС, BC;
        double S;

        public Triangle() {
            createTriangle();
            S = Area();
        }

        public void createTriangle(){
             A = new Dot();
             B = new Dot();
             C = new Dot();

             AB = sideLength(A, B);
             AС = sideLength(A, C);
             BC = sideLength(B, C);
        }

        public double Area(){

            double p = (AB + AС + BC) / 2;
            double area = Math.sqrt(p * (p - AB) * (p - AС) * (p - BC));

            return area;
        }

        private double sideLength(Dot start, Dot end){
            return Math.sqrt(Math.pow((start.X-end.X),2)+Math.pow((start.Y-end.Y),2));
        }

        public double perimeter(){
            return AB + AС + BC;
        }

        @Override

        public String toString(){
            return String.format("A(%f;%f), B(%f;%f), C(%f,%f), S = %f",
                    A.X, A.Y, B.X, B.Y, C.X, C.Y, S);
        }
    }

    public static class HashTable {
        private Triangle arr[];
        private int size;
        public HashTable(int Size) {
            arr = new Triangle[Size];
            size = Size;
        }

        public int hashFunc(Triangle triangle) {
            int key = (int)triangle.S;
            int hash = key%size;
            return hash;
        }

        public int hashFuncMult(Triangle triangle){
            double key = triangle.S;
            double A = 0.618;
            int hash = (int) (key*A - (int)(key*A)*size);
            return hash;
        }

        public boolean insert(Triangle triangle) {

            int index = hashFuncMult(triangle);

            if (arr[index] == null) {
                arr[index] = triangle;
                return true;
            } else {
                System.out.println("Collision");
                return false;
            }

        }

        public void print(){
            for(int i = 0; i < arr.length; i++){
                if(arr[i]!=null){
                    System.out.println(i+" "+arr[i].toString());
                }
            }
        }
    }
    public static void Demonstrate(){
        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle();
        Triangle triangle3 = new Triangle();
        Triangle triangle4 = new Triangle();

        HashTable newHashTable = new HashTable(4);

        newHashTable.insert(triangle1);
        newHashTable.insert(triangle2);
        newHashTable.insert(triangle3);
        newHashTable.insert(triangle4);

        newHashTable.print();
    }
}


