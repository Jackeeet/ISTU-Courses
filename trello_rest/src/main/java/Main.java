import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Main {
    public static void main(String[] args) {
        String uri = "https://api.trello.com";
        String contentType = "application/json; charset=utf-8";
        String boardID = "5fe8a8bcf726a4182c3ce5ad";
        String firstListID = "5fe8aaf52b3f401e0bda7f0e";

        // создание CardForAPI и сохранение ее id
        Map<String, Object> params = new HashMap<>();
        initialiseAPICardParams(params, firstListID);
        String APICardID =
                given().baseUri(uri).queryParams(params).contentType(contentType)
                        .when().post("/1/cards")
                        .then().statusCode(200).extract().path("id");

        // создание CardForDelete и сохранение ее id
        params.put("name", "CardForDelete");
        String deleteCardID =
                given().baseUri(uri).queryParams(params).contentType(contentType)
                        .when().post("/1/cards")
                        .then().statusCode(200).extract().path("id");

        // обновление CardForAPI
        Map<String, Object> cardParams = new HashMap<>();
        initialiseUpdatedCardParams(cardParams);
        given().baseUri(uri).queryParams(cardParams).contentType(contentType)
                .when().put("/1/cards/{id}", APICardID)
                .then().statusCode(200);

        // создание столбца ApiList
        Map<String, Object> listParams = new HashMap<>();
        initialiseListParams(listParams, boardID);
        String apiListID =
                given().baseUri(uri).queryParams(listParams).contentType(contentType)
                        .when().post("/1/lists")
                        .then().statusCode(200).extract().path("id");

        // перемещение CardForAPI в столбец ApiList
        cardParams.put("idList", apiListID);
        given().baseUri(uri).queryParams(cardParams).contentType(contentType)
                .when().put("/1/cards/{id}", APICardID)
                .then().statusCode(200);

        // удаление CardForDelete
        Map<String, Object> deleteCardParams = new HashMap<>();
        deleteCardParams.put("key", Tokens.key);
        deleteCardParams.put("token", Tokens.token);
        given().baseUri(uri).queryParams(deleteCardParams).contentType(contentType)
                .when().delete("/1/cards/{id}", deleteCardID)
                .then().statusCode(200).extract().path("id");
    }

    private static void initialiseAPICardParams(Map<String, Object> cardParams, String listID) {
        cardParams.put("key", Tokens.key);
        cardParams.put("token", Tokens.token);
        cardParams.put("name", "CardForAPI");
        cardParams.put("idList", listID);
    }

    private static void initialiseUpdatedCardParams(Map<String, Object> cardParams) {
        cardParams.put("key", Tokens.key);
        cardParams.put("token", Tokens.token);
        cardParams.put("desc", "The peregrine falcon (Falco peregrinus), also known as the peregrine, and historically as the duck hawk in North America, is a widespread bird of prey in the family Falconidae.");
    }

    private static void initialiseListParams(Map<String, Object> listParams, String boardID){
        listParams.put("key", Tokens.key);
        listParams.put("token", Tokens.token);
        listParams.put("name", "ApiList");
        listParams.put("idBoard", boardID);
    }
}
