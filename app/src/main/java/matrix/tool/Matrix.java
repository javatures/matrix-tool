package matrix.tool;

//import java.io.FileNotFoundException;
//import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.io.File;
import java.io.FileNotFoundException;

public class Matrix{
  //matrix member variables
  private int numRows = 0;
  private int numColumns = 0;
  private int[][] matrix;
  private String uniqueID;
  public static final String usageMessage = "Matrix(rows, columns)";

   //no arg constructor
   public Matrix(){
       System.out.print(usageMessage);
   }

   //constructor with matrix dimensions as parameters
   public Matrix(int numRows, int numColumns){
       this.uniqueID = UUID.randomUUID().toString();
       this.numColumns = numColumns;
       this.numRows = numRows;
       this.matrix = new int[this.numRows][this.numColumns];
       System.out.println(this.numRows + " x " + this.numColumns + " matrix successfully created with id "+ this.uniqueID);
   }
   //constructor to populate matrix from file
    public Matrix(int numRows, int numColumns, String filename, Scanner scanner){
       this.uniqueID = UUID.randomUUID().toString();
       this.numColumns = numColumns;
       this.numRows = numRows;
       this.matrix = new int[this.numRows][this.numColumns];
       System.out.println(this.numRows + " x " + this.numColumns + " matrix successfully created with id "+ this.uniqueID);
       try{
           File file = new File(filename);
           scanner = new Scanner(file);
           for(int i = 0; i < this.numRows; i++){
               String[] elements = scanner.nextLine().split(",");
               for (int j = 0; j < numColumns; j++){
                   this.matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
            scanner.close();
       }
       catch(FileNotFoundException ex){
           ex.printStackTrace();
           System.out.println("File not found");
       }
    }
    //constructor to populate matrix from console input
    public Matrix(int numRows, int numColumns, Scanner scanner){
        this.uniqueID = UUID.randomUUID().toString();
        this.numColumns = numColumns;
        this.numRows = numRows;
        this.matrix = new int[this.numRows][this.numColumns];
        System.out.println(this.numRows + " x " + this.numColumns + " matrix successfully created with id "+ this.uniqueID);
        for(int i = 0; i < numRows; i++){
            for (int j = 0; j < numColumns; j++){
                System.out.println("row "+ i + " column " + j + ":");
                this.matrix[i][j] = scanner.nextInt();
            }
        }
    }

   //matrix object member functions
   public int getNumRows(){
       return this.numRows;
   }

   public int getNumColumns(){
       return this.numColumns;
   }
   public String getId(){
       return this.uniqueID;
   }
   public void setElement(int row, int column, int value){
       this.matrix[row][column] = value;
   }
   public int getElement(int row, int column){
       return this.matrix[row][column];
   }
   
   public void clear(){
    for(int i = 0; i < this.numRows; i++){
        for(int j = 0; j < this.numColumns; j++){
            //remember to add bound option
            this.matrix[i][j] = 0;
        }
    }
    }

   public void print(){
       for(int i = 0; i < this.numRows; i++){
           for(int j = 0; j < this.numColumns; j++){
               System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

   public void add(Matrix m){
       if (m.getNumColumns() == this.numColumns && m.getNumRows() == this.numRows){
           for(int i = 0; i < this.numRows; i++){
               for(int j = 0; j < this.numColumns; j++){
                   this.matrix[i][j] += m.matrix[i][j];
               }
            }
       }
       else{
           System.out.println("Matrix dimensions must be the same to add");
       }
   }

   public void subtract(Matrix m){
    if (m.getNumColumns() == this.numColumns && m.getNumRows() == this.numRows){
        for(int i = 0; i < this.numRows; i++){
            for(int j = 0; j < this.numColumns; j++){
                this.matrix[i][j] -= m.matrix[i][j];
            }
         }
    }
    else{
        System.out.println("Matrix dimensions must be the same to subtract");
        }
    }

    public void multiply(int scalar){
        for(int i = 0; i < this.numRows; i++){
            for(int j = 0; j < this.numColumns; j++){
                this.matrix[i][j] *= scalar;
            }
         }
    }  


}
