import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;
class Derivative {
    public String operation;
    public String menu = "\nOp1 simpleDer\nOp2 advanceDer\nOp3 Zad1\nOp4 Zad2\nOp5 Zad3";
    public int checkInputs(Scanner scanner){
        while (!scanner.hasNextInt()){
            Main.printStr("enter valid int:");
            scanner.next();
        }
        int sc_res = scanner.nextInt();
        return sc_res;
    }
    public int makeCalc1(int c){
        return 0;
    }
    public int makeCalc2(int p){
        int res = p - 1;
        return res;
    }
    public int makeCalc3(int a, int p){
        int res = a * p;
        return res;
    }
    public void simpleDer(int a, int p) {
        int calculation = a * p;
        int exp = p - 1;
        String line = "df = df(" + a + "x^" + p + ") = " + calculation + "x^" + exp;
        Main.printStr(line);
    }
    public void advanceDer(int a, int b, int c, int exp1, int exp2, int exp3) {
        int calc01 = exp1 * a;
        int exp1_res = exp1 - 1;
        int calc02 = b * exp2;
        int exp2_res = exp2 - 1;
        int calc03 = c * exp3;
        int exp3_res = exp3 - 1;
        String part01 = "df = df(" + a + "x^" + exp1 + " + " + b + "x^" + exp2+" + "+ c +"x^" + exp3+ ")";
        String part02 = calc01 + "x^" + exp1_res + " + " + calc02 + "x^" + exp2_res+ " + " + calc03 + "x^" + exp3_res;
        Main.printStr(part01 + " = " + part02);
    }
    public String getF1(){
        String f = "15";
        return f;
    }
    public String getDerG1(){
        String g = "1/(2√x)";
        return g;
    }
    public void getFinalDer1(){
        String part1 = this.getF1();
        String part2 = this.getDerG1();
        String final_der1 = "df = "+ part1 + "*" + part2;
        System.out.println(final_der1);
    }
    public String getF2(){
        String f = "3";
        return f;
    }
    public String getDerG2(){
        String g = "1/(2√x)";
        return g;
    }
    public String getDerH2(){
        int a1 = this.makeCalc3(2, 8);
        int p1 = this.makeCalc2(8);
        String line = a1 + "x^" + p1;
        return line;
    }
    public String getDerI2(){
        int a1 = this.makeCalc3(12,6);
        int p1 = this.makeCalc2(6);
        String line = a1 + "x^" + p1;
        return line;
    }
    public void getFinalDer2(){
        String part1 = this.getF2();
        String part2 = this.getDerG2();
        String part3 = this.getDerH2();
        String part4 = this.getDerI2();
        String final_der2 = "df = " + part1 + "*" + part2 + "+" + part3 + "+" +part4;
        System.out.println(final_der2);
    }
    public int getDerF3(){
        int c1 = this.makeCalc1(3);
        return c1;
    }
    public String getDerG3(){
        int a1 = this.makeCalc3(1,5);
        int p1 = this.makeCalc2(5);
        String line = a1 + "x^" + p1;
        return line;
    }
    public String getF3(){
        String f = "3";
        return f;
    }
    public String getG3(){
        String g = "x^5";
        return g;
    }
    public String getDerG32(){
        int p2 = this.makeCalc3(5,2);
        String line = "x^"+p2;
        return line;
    }
    public void getFinalDer3(){
        String part1 = this.getG3();
        String part2 = this.getF3();
        String part3 = this.getDerG3();
        String part4 = this.getDerG32();
        String final_der3 = "df = ("+getDerF3()+ "" +part1+ "-" +part2+ "" + part3+")/"+part4;
        System.out.println(final_der3);
    }
}
public class Main {
    static boolean run = true;
    public static void menu(String menu) {
        printStr(menu);
    }
    public static void printStr(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Derivative der01 = new Derivative();
        do {
            menu(der01.menu);
            der01.operation = scanner.next();
            try {
                switch (der01.operation) {
                    case "Op1":
                        printStr("Enter a:");
                        int a1 = der01.checkInputs(scanner);
                        printStr("Enter p:");
                        int p1 = der01.checkInputs(scanner);
                        der01.simpleDer(a1, p1);
                        break;
                    case "Op2":
                        printStr("Enter a:");
                        int a2 = der01.checkInputs(scanner);
                        printStr("Enter b:");
                        int b2 = der01.checkInputs(scanner);
                        printStr("Enter c:");
                        int c2 = der01.checkInputs(scanner);
                        printStr("Enter exp1:");
                        int exp1 = der01.checkInputs(scanner);
                        printStr("Enter exp2:");
                        int exp2 = der01.checkInputs(scanner);
                        printStr("Enter exp3:");
                        int exp3 = der01.checkInputs(scanner);
                        der01.advanceDer(a2, b2, c2, exp1, exp2, exp3);
                        break;
                    case "Op3":
                        der01.getFinalDer1();
                        break;
                    case "Op4":
                        der01.getFinalDer2();
                        break;
                    case "Op5":
                        der01.getFinalDer3();
                        break;
                    case "Exit":
                        System.out.println("You have exited the calculator");
                        System.exit(0);
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid");
                }
            } catch (InputMismatchException e) {
                printStr(e.getMessage());
            }
        } while (run == true);
        scanner.close();
    }
}




