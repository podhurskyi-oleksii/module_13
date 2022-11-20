import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Task1 {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static User sendPost(String url, User user) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/users");
        String requestBody = User.transformToJson(user);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return User.transformToClass(response.body());
    }

    public static User sendPut(String url, User user) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/posts/" + user.getId());
        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json; charset=UTF-8")
                .build();
        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static int sendDelete(String url, int id) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/posts/" + id);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .DELETE()
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public static ArrayList<User> sendGet(String url) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/users");
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        String test = response.body().substring(1, response.body().length() - 1);
        ArrayList<User> result = new ArrayList<>();

        while (test.length() > 1) {
            int st = test.indexOf('{');
            int a = test.indexOf('}');
            int b = test.indexOf('}', a + 1);
            int c = test.indexOf('}', b + 1);
            int d = test.indexOf('}', c + 1);
            String s = test.substring(st, d + 1);
            result.add(User.transformToClass(s));
            test = test.substring(d + 1);
        }
        return result;
    }

    public static User sendGetId(String url, int id) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/users/" + id);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return User.transformToClass(response.body());
    }

    public static User getUserByUsername(String url, String username) throws IOException, InterruptedException {
        URI uri = URI.create(url + "/users?username=" + username);
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = // HTTP-ответ.
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return User.transformToClass(response.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com";

        User user1 = Task1.sendPost(url, User.defaultUser());
        System.out.println(user1 + "\n");

        User user2 = Task1.sendPut(url, User.defaultUser());
        System.out.println(user2 + "\n");

        int user3 = Task1.sendDelete(url, 3);
        System.out.println(user3 + "\n");

        ArrayList<User> user4 = sendGet(url);
        System.out.println(user4 + "\n");

        User user5 = Task1.sendGetId(url, 2);
        System.out.println(user5 + "\n");

        User user6 = Task1.getUserByUsername(url, "Samantha");
        System.out.println(user6);
    }
}
