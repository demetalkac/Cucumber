package stepdefinitions.api_stepdefinitions;
import base_urls.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.Room;

import java.io.IOException;
import java.util.HashMap;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.AuthenticationMedunna.generateToken;

public class RoomCreation {

    Response response;
    Room expectedData = new Room(); // to reach expectedData object from other(assertion) method
    int fakeRoomNumber;
    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
        //MedunnaBaseUrl.medunnaSetUp(); // Or call this method in Hooks class and it will be called automatically
        spec.pathParams("first", "api", "second", "rooms");


        fakeRoomNumber = Faker.instance().number().numberBetween(1000, 1000000);
        expectedData.setRoomNumber(fakeRoomNumber);
        //expectedData.setRoomNumber(158635445);
        expectedData.setRoomType("TWIN");
        expectedData.setStatus(true);
        expectedData.setPrice(100);
        expectedData.setDescription("This room is created by API");

        response = given().spec(spec).headers("Authorization", "Bearer "+ generateToken(), "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();

    }

    @Then("user gets the room data and validates")
    public void user_gets_the_room_data_and_validates() throws IOException {
        assertEquals(201, response.getStatusCode());

        //1.Validation
        //Soft assertion ==>> single body method
//        response.then().
//                assertThat().
//                body("roomNumber", equalTo(fakeRoomNumber),
//                "roomType", equalTo("TWIN"),
//                        "status", equalTo(true),
//                        "price", equalTo(100),
//                        "description", equalTo("This room is created by API"));

        //Hard assertion ==>> multiple body method
        response.then().
                assertThat().
                body("roomNumber", equalTo(fakeRoomNumber)).
                body("roomType", equalTo("TWIN")).
                body("status", equalTo(true)).
                body("price", equalTo(100)).body("description", equalTo("This room is created by API"));

        //2.Validation
        JsonPath json = response.jsonPath();
        assertEquals(expectedData.getRoomNumber(), json.getInt("roomNumber"));
        assertEquals(expectedData.getRoomType(), json.getString("roomType"));
        assertEquals(expectedData.getStatus(), json.getBoolean("status"));
        assertEquals(expectedData.getPrice(), json.getInt("price"));
        assertEquals(expectedData.getDescription(), json.getString("description"));

        //3. Validation
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("Actual Data = "+ actualDataMap);

        assertEquals(expectedData.getRoomNumber(), actualDataMap.get("roomNumber"));
        assertEquals(expectedData.getRoomType(), actualDataMap.get("roomType"));
        assertEquals(expectedData.getStatus(), actualDataMap.get("status"));
        assertEquals(expectedData.getPrice(), actualDataMap.get("price"));
        assertEquals(expectedData.getDescription(), actualDataMap.get("description"));

        //4. Validation
        //We commented out this validation because 4 and 5 works with different jsonIgnore properties
        // To run validation 4 ==>> JsonIgnoreProperties should be imported from ==>> "import com.fasterxml.jackson.annotation.JsonIgnoreProperties;"
//        Room actualDataPojo = response.as(Room.class);
//        System.out.println("Actual Data = "+ actualDataPojo);
//
//        assertEquals(expectedData.getRoomNumber(), actualDataPojo.getRoomNumber());
//        assertEquals(expectedData.getRoomType(), actualDataPojo.getRoomType());
//        assertEquals(expectedData.getStatus(), actualDataPojo.getStatus());
//        assertEquals(expectedData.getPrice(), actualDataPojo.getPrice());
//        assertEquals(expectedData.getDescription(), actualDataPojo.getDescription());

        //5. Validation
        ObjectMapper mapper = new ObjectMapper();

        Room actualRoom = mapper.readValue(response.asString(), Room.class);
        assertEquals(expectedData.getRoomNumber(), actualRoom.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualRoom.getRoomType());
        assertEquals(expectedData.getStatus(), actualRoom.getStatus());
        assertEquals(expectedData.getPrice(), actualRoom.getPrice());
        assertEquals(expectedData.getDescription(), actualRoom.getDescription());


    }
     }
