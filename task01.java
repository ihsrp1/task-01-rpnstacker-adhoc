// Your First Program

import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.File;  // Import the File class

class SolverRPN {
  private static int doOp (Integer[] numbers, String op) {
    Integer result = numbers[numbers.length-1];
    for (int i = numbers.length-2; i >= 0; i--){
      if (op.equals("+")) {
        System.out.println(result + " " + op + " " + numbers[i]); 
        result += numbers[i];
      } else if (op.equals("-")) {
        System.out.println(result + " " + op + " " + numbers[i]); 
        result -= numbers[i];
      } else if (op.equals("*")) {
        System.out.println(result + " " + op + " " + numbers[i]); 
        result *= numbers[i];
      } else if (op.equals("/")) {
        System.out.println(result + " " + op + " " + numbers[i]); 
        result /= numbers[i];
      }
    }
    System.out.println("Resultado Parcial: "+result); 
    return result;
  }
  public static void main(String[] args) {
    try {
      File myObj = new File("Calc1.stk");
      Scanner myReader = new Scanner(myObj);
      Stack <Integer> stk = new Stack();
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
          Integer[] numbers;
          numbers = new Integer[stk.size()];
          int i = 0;
          while(!stk.empty()){
            numbers[i] = stk.pop();
            i++;
          }
          int result = doOp(numbers, data);
          stk.push(result);
        } else {
          stk.push(Integer.parseInt(data));
        }
      }
      System.out.println(stk.pop());
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}