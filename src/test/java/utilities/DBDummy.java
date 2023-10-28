package utilities;
import java.util.List;

public class DBDummy {

    public static void main(String[] args) {

        DBUtils.createConnection();

        String query = "SELECT login FROM jhi_user WHERE id = 16417";
        System.out.println(DBUtils.getCellValue(query));

        List<Object> objectList = DBUtils.getRowList("SELECT * FROM jhi_user WHERE id = 16417");
        System.out.println("objectList" + objectList);

        List<Object> loginList = DBUtils.getColumnData("SELECT login FROM jhi_user", "login");
        System.out.println("loginList" + loginList);

        DBUtils.closeConnection();




    }

}


