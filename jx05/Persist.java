  package jx05;

  import java.io.BufferedWriter;
  import java.io.BufferedReader;
  import java.io.FileWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;

  public class Persist {

    public static void main(String[] args) {

      String buff = null;

      try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter("student.txt"));){
        System.out.println("一人以上の学生の番号、氏名を記入してください");
        try(BufferedReader buffKeyboard = new BufferedReader(new InputStreamReader(System.in));) {
          do {
            System.out.print("No: ");
            buff = buffKeyboard.readLine();
            if(buff.equals("q")) {
              break;
            }
            buffWriter.write(buff + " ");
            System.out.print("Name: ");
            buff = buffKeyboard.readLine();
            buffWriter.write(buff);
            buffWriter.newLine();
          }
          while(true);
        }
        catch(IOException e) {
          System.out.println("Keyboard Input Error");
        }
      }
      catch(IOException e) {
        System.out.println("Write Error");
      }
    }
  }
