import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Crawler extends Thread {
    
    //list of all pages searched
    private static ArrayList<String> viewedPages = new ArrayList<String>();
    private int i;
    private String url;
    private static fileWriter fwrite;

    //initialise Crawler and set level and url to crawl
    public Crawler(int i, String url) {

        viewedPages = new ArrayList<String>();
        this.url = url;
        fwrite = new fileWriter();
    }

    public void run() {
        crawl(i,url, viewedPages);
    }

    // public void start() {
    //     crawl(i, url, viewedPages);
    // }

    
    // public static void main(String args[]) {
    
    //     String website = args[0];
        
    //     crawl(0,website,viewedPages);
    
        
    // }

    //recursive function to request a webpage, iterate through href tages recursively calling itself on each one
    private static void crawl(int level, String url, ArrayList<String> visited) {
        //filter out download links
        if(url.contains(".pdf")) {
            
        }
        else {
            if(level <= 1) {
                //fill document
                Document doc = request(url, visited);


                if(doc != null) {
                    //iterate through each href link found in doc
                    for(Element link : doc.select("a[href]")) {
                        //get next link to visit
                        String next_link = link.absUrl("href");
                        //check we havent visited link before
                        if(visited.contains(next_link) == false) {
                            //open link and increase depth
                            crawl(level++, next_link, visited);
                        }
                    }
                }
            }
        }
    }
    //function that takes a url as a string and an array to keep track of each page visited
    private static Document request(String url, ArrayList<String> v) {
        try {
            //establish connection to url provided
            Connection con = Jsoup.connect(url);
            //sleep thread as to not request too fast
            Thread.sleep(100);
            //download contents of page and store in an html document
            Document doc = con.get();

            //if successful connection (returns HTTP status code 200)
            if(con.response().statusCode() == 200) {
                System.out.println("Link: " + url);
                System.out.println(doc.title());
                fwrite.writeFile(doc.title(),doc.toString());
                //add url to list of visited urls
                v.add(url);
                //return contents of page
                return doc;
            }
            return null;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
