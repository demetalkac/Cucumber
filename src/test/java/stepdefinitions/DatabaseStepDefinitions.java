package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;
import java.sql.SQLException;
import java.util.List;
//NOT: bu clss "gmibank" icin yaptık dbutilities de bu classı calıstırınca comment te aldıgım yeri ac
public class DatabaseStepDefinitions {
    @Given("user connects to the application database")
    public void user_connects_to_the_application_database() {
//        creating database connections using database utility class
        DBUtils.createConnection();
    }
    @Given("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String column, String table) {
//        String query = "SELECT * FROM jhi_user";//HARD CODED
        String query = "SELECT "+column+" FROM "+table+" Order By Id";//DYNAMIC QUERY
//        Running the query using util class
        DBUtils.executeQuery(query);
    }
    @Then("user reads all the column {string} data")
    public void user_reads_all_the_column_data(String column) throws Exception {
//        Using result set, get the objects from the database
        DBUtils.getResultset().next();//going to the next row
        Object object1 = DBUtils.getResultset().getObject(column);//getObject is used to get the database objects
        System.out.println(object1);
//        -----------
        DBUtils.getResultset().next();//going to the next row
        Object object2=DBUtils.getResultset().getObject(column);
        System.out.println(object2);
//        -----------------
        DBUtils.getResultset().next();//going to the next row
        Object object3=DBUtils.getResultset().getObject(column);
        System.out.println(object3);
//        --------------------
        DBUtils.getResultset().next();//going to the next row
        Object object4=DBUtils.getResultset().getObject(column);
        System.out.println(object4);

        int rowNum=4;
        while (DBUtils.getResultset().next()){//continue to go to the next row until there is no more row exist
            Object currentRowObject = DBUtils.getResultset().getObject(column);
            System.out.println("Row "+rowNum+" data => "+currentRowObject);
            rowNum++;

        }

        System.out.println("Row Count : "+rowNum);
        System.out.println("Row Count : "+DBUtils.getRowCount());

    }

//#    TEST ACCOUNT TABLE ACCOUNT_TYPE COLUMN CONTAINS 4 ACCOUNT TYPE: CREDIT CARD, SAVING, CHECKING, INVESTING
    @Then("verify table {string} and column {string} contains data {string}")
    public void verify_table_and_column_contains_data(String table, String column, String data) {
//      getting to the table
        String query = "SELECT "+column+" FROM "+table;

//      getting all the column data and storing in a list
        List<Object> columnData = DBUtils.getColumnData(query,column);
        System.out.println(columnData);
        Assert.assertTrue(columnData.contains(data));

    }


}
