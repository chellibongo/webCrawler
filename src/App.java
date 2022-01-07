
public class App {

    private static terminalInput termIn;

    public static void main(String[] args) {
        termIn = new terminalInput();
        try {
            System.out.println("Welcome to my web crawler, enter web address to crawl: ");
            String url = termIn.readString();
            System.out.println(url);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
