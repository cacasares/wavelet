import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.

    public String handleRequest(URI url) {
        String inputs="";
        if (url.getPath().contains("/add-message?s=")) {
            inputs= url.getQuery().split("=") + "\n";
            //System.out.println(inputs);
            return inputs;
        }
        return "404 Not Found!";
    }


class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
}
