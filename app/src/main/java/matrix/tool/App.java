package matrix.tool;

import java.util.Scanner;
import java.util.HashMap;
//import java.io.File;


public class App {
    boolean running = false;
    int choice = -1;
    static final String menu = "What would you like to do?\r\n(1) Create matrix\r\n(2) Operate on matrix\r\n(0) Exit program";
    Scanner s;
    Scanner r;
    HashMap<String, Matrix> matrices;

    public App(){
        System.out.println("App object created successfully");
        this.s = new Scanner(System.in);
        this.r = new Scanner(System.in);
    }
    
    public void start(){
        this.running = true;
        matrices = new HashMap<String, Matrix>();
        System.out.println("App started successfully\r\n\r\n");

        //application loop
        while (this.running){
            System.out.println(menu);
            this.choice = s.nextInt();
            //create matrix
            if (choice == 1){
                int rows, columns;
                System.out.println("Please enter number of rows:");
                rows = this.s.nextInt();
                System.out.println("Please enter number of columns:");
                columns = this.s.nextInt();
                System.out.println("How would you like to populate this matrix?\r\n(1) Keyboard Input\r\n(2) File Input\r\n(3) Leave matrix empty(all elements=0)");
                choice = this.s.nextInt();
                //input from console
                if (choice == 1){

                    System.out.println();
                    Matrix m = new Matrix(rows,columns, this.s);
                    matrices.put(m.getId(), m);
                    m.print();
                }
                //input from file
                else if (choice == 2){
                    //file constructor
                    System.out.println("Please enter filename:");
                    if (this.s.hasNext()){
                        String filename = this.s.next();
                        System.out.println(filename);
                        Matrix f = new Matrix(rows, columns, filename, this.s);
                        matrices.put(f.getId(), f);
                        f.print();
                    }
                    else{
                        String filename = "matrix.txt";
                        Matrix f = new Matrix(rows, columns, filename, this.s);
                        matrices.put(f.getId(), f);
                        f.print();
                    }
                    
                }
                //empty/null matrix
                else if (choice == 3){
                    Matrix n = new Matrix(rows, columns);
                    matrices.put(n.getId(), n);
                    n.print();
                }
                //usage message?
                else{
                    System.out.println("Invalid choice");
                    continue;
                }
                
            }
            //operate on matrix
            else if(choice == 2){
                //menu message: add subtract multiply clear

                System.out.println("Please enter matrix id:");
                if (this.r.hasNext()){
                    String id = this.r.next();
                    Matrix operatingMatrix = matrices.get(id);
                    operatingMatrix.print();
                }
                else{
                    System.out.println("invalid");
                }
                
            }
            //quit app
            else if (choice == 0){
                System.out.println("Goodbye");
                this.running = false;
                this.s.close();
                break;
            }
            //invalid choice, print usage message
            else{
                System.out.println(menu);
                continue;
            }

        }
    }
    
    public static void main(String[] args) {
        App app = new App();
        app.start();
        
    }
}