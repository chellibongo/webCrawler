import java.util.Scanner;

public class terminalInput {
    
    Scanner scanner;

    public terminalInput() {
        scanner = new Scanner(System.in);
    }

    public void writeTerminal(String string) {
        System.out.println(string);
    }

    public String readString() {
        try {
            String string = scanner.next();
            return string;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

    public int readInt() {
        return scanner.nextInt();
    }
}
