package pl.camp.it.rest.client;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiClient {
    public User getUser(String name, String surname,
                        int age, long pesel,
                        String header1, String header2,
                        User user) {
        RestTemplate restTemplate = new RestTemplate();

        String url3 = "http://localhost:8080/rest4/{name}/{surname}";

        Map<String, String> pathParameters = new HashMap<>();
        pathParameters.put("name", name);
        pathParameters.put("surname", surname);

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url3)
                .queryParam("age", age)
                .queryParam("pesel", pesel)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("header1", header1);
        httpHeaders.add("header2", header2);

        HttpEntity<User> request = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<User> response = restTemplate.exchange(
                uriComponents.toUriString(),
                HttpMethod.POST,
                request,
                User.class,
                pathParameters);

        /*HttpStatusCode statusCode = response.getStatusCode();
        int kodOdpowiedzi = statusCode.value();
        System.out.println("kod odpowiedzi: " + kodOdpowiedzi);*/
        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException();
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
        System.out.println(responseBody.getAge());

        return responseBody;
    }
}
