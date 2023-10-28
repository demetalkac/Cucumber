package utilities;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

//    public static void main(String[] args) {
//        System.out.println(generateToken());
//    }

    public static String generateToken(){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("password", "Team05+");
        hashMap.put("rememberMe", true);
        hashMap.put("username", "AdminTeam05");
        Response response = given().contentType(ContentType.JSON).body(hashMap).when().post("https://medunna.com/api/authenticate");

        //response.prettyPrint();

        return response.jsonPath().getString("id_token");
    }

}

/*
{
  "password": "Team05+",
  "rememberMe": true,
  "username": "AdminTeam05"
}

 */


