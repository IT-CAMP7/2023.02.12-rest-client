package pl.camp.it.rest.client;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        /************** GET ***************/
        String url = "http://localhost:8080/rest1";

        /*User user = restTemplate.getForObject(url, User.class);

        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());*/

        /********************* POST ******************/
        String url2 = "http://localhost:8080/rest2";

        User user1 = new User("jan", "janek11",
                "Jan", "Kowalski", 20);

        //restTemplate.postForObject(url2, user1, Void.class);

        /******************* EXCHANGE ******************/
        System.out.println("-------------------------------------------------");
        /*String url3 = "http://localhost:8080/rest4/{name}/{surname}";

        Map<String, String> pathParameters = new HashMap<>();
        pathParameters.put("name", "janusz");
        pathParameters.put("surname", "kowalski");

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url3)
                .queryParam("age", 34)
                .queryParam("pesel", 123123123)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header1", "cos");
        httpHeaders.add("header2", "cos innego");

        User user2 = new User("jan", "janek11",
                "Jan", "Kowalski", 20);

        HttpEntity<User> request = new HttpEntity<>(user2, httpHeaders);

        ResponseEntity<User> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.POST,
                request,
                User.class,
                pathParameters);

        *//*HttpStatusCode statusCode = response.getStatusCode();
        int kodOdpowiedzi = statusCode.value();
        System.out.println("kod odpowiedzi: " + kodOdpowiedzi);*//*
        if(response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Jest spoko, przyszlo 200 !!");
        }
        HttpHeaders headers = response.getHeaders();
        for(Map.Entry<String, List<String>> header : headers.entrySet()) {
            System.out.println(header.getKey() + " - " + header.getValue());
        }
        User responseBody = response.getBody();
        System.out.println("Body:");
        System.out.println(responseBody.getName());
        System.out.println(responseBody.getSurname());
        System.out.println(responseBody.getLogin());
        System.out.println(responseBody.getPassword());
        System.out.println(responseBody.getAge());*/
        ApiClient apiClient = new ApiClient();
        apiClient.getUser("zbyszek", "malinowski", 34, 234234234,
        "h1", "h2",
                new User("jan", "janek11",
                "Jan", "Kowalski", 20));
    }
}
