
public class App {

    public static void main(String[] args) {

        //set depth for crawler to go to
        int depth = 1;
        //initiate new instance of webcrawler
        Crawler crawler = new Crawler(depth, args[0]);
        crawler.start();

    }
}
