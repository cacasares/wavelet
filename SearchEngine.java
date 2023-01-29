import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    ArrayList<String> searches = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Please enter a string:");
        } 
        else if (url.getPath().equals("/CSE")) {
            num += 1;
            return String.format("Computer science slays!");
        } 
        else if (url.getPath().contains("/search")){
            ArrayList<String> list= new ArrayList<>();
            String[] inputs = url.getQuery().split("=");
            for(String search: searches){
                if(search.contains(inputs[1])){
                    list.add(search);
                }
            }
            return String.format("Words with %s: %s", inputs[1], list.toString());
        }
        else {
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        //tracks a list of strings. It should support a path for adding a new string to the list, and a path for querying the list of strings and returning a list of all strings that have a given substring.
        ArrayList<String> searches= new ArrayList<>();


        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        searches.add(url.getPath());
        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}


