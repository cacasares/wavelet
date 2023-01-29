import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String inputs="";

    public String handleRequest(URI url) {
        //this message to enter a string should return once the user first opens the webpage
        if (url.getPath().equals("/")) {
            //intial message
            return String.format("Please enter a string: ");
            //if the user includes a path that has '/add-message', take the string after the '='
        } else if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            //continuously concatenate the string (/add-message?s=<string>) after the '=' to the initialized empty string input
            inputs+= parameters[1]+ "\n";
            return String.format(inputs);
        } else {
            System.out.println("Path: " + url.getPath());
            return "404 Not Found!";
        }
    }
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

// class Handler implements URLHandler {
//     // The one bit of state on the server: a number that will be manipulated by
//     // various requests.

//     public String handleRequest(URI url) {
//         String inputs="";
//         if (url.getPath().contains("/add-message?s=")) {
//             inputs= url.getQuery().split("=") + "\n";
//             //System.out.println(inputs);
//             return inputs;
//         }
//         return "404 Not Found!";
//     }


// class StringServer {
//     public static void main(String[] args) throws IOException {
//         if(args.length == 0){
//             System.out.println("Missing port number! Try any number between 1024 to 49151");
//             return;
//         }

//         int port = Integer.parseInt(args[0]);

//         Server.start(port, new Handler());
//     }
// }
// }

// import java.io.IOException;
// import java.net.URI;

// class Handler implements URLHandler {
//     // The one bit of state on the server: a number that will be manipulated by
//     // various requests.
//     int num = 0;

//     public String handleRequest(URI url) {
//         if (url.getPath().equals("/")) {
//             return String.format("Carl's Number: %d", 725);
//         } else if (url.getPath().equals("/increment")) {
//             num += 1;
//             return String.format("Number incremented!");
//         } else {
//             System.out.println("Path: " + url.getPath());
//             if (url.getPath().contains("/add")) {
//                 String[] parameters = url.getQuery().split("=");
//                 if (parameters[0].equals("count")) {
//                     num += Integer.parseInt(parameters[1]);
//                     return String.format("Number increased by %s! It's now %d", parameters[1], num);
//                 }
//             }
//             return "404 Not Found!";
//         }
//     }
// }

// class NumberServer {
//     public static void main(String[] args) throws IOException {
//         if(args.length == 0){
//             System.out.println("Missing port number! Try any number between 1024 to 49151");
//             return;
//         }

//         int port = Integer.parseInt(args[0]);

//         Server.start(port, new Handler());
//     }
// }
