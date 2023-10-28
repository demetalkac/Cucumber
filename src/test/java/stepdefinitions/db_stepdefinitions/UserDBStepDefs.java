package stepdefinitions.db_stepdefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class UserDBStepDefs {

    List<Object> columnList;

    @Given("user connect to the application database")
    public void user_connect_to_the_application_database() {

        DBUtils.createConnection();
    }

    @When("get all {string} as a list from {string}")
    public void get_all_usernames_as_a_list(String columnName, String table) {
        String query = "SELECT * FROM " + table;
        columnList = DBUtils.getColumnData(query, columnName);
        System.out.println("columnList " + columnList);
    }

    @Then("verify usernameList contains {string}")
    public void verify_username_list_contains(String username) {

        Assert.assertTrue(columnList.contains(username));
    }

    @Then("close the connection")
    public void close_the_connection() {
        DBUtils.closeConnection();
    }

    @Then("verify emailList contains {string}")
    public void verifyEmailListContains(String email) {

        Assert.assertTrue(columnList.contains(email));
    }

    @Then("verify roomList contains {string}")
    public void verifyRoomListContains(String roomNumber) {
        Assert.assertTrue(columnList.contains(Integer.valueOf(roomNumber)));
    }
}

