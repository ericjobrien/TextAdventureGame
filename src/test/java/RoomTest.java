import com.revature.collections.GenericArrayList;
import com.revature.dao.RoomDAO;
import com.revature.model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void checkRoom() {
        RoomDAO roomDAO = new RoomDAO();
        int roomCount = roomDAO.getRoomCount();


        GenericArrayList genericArrayList = roomDAO.getAllRooms();

        Room[] roomArray = (Room[]) genericArrayList.getGenericArray();

        Room roomToCheck = roomArray[0];
        String roomToCheckName = roomToCheck.getName();

        Assertions.assertTrue(!roomToCheckName.equals(null));
        Assertions.assertTrue(roomToCheckName.equals(roomArray[0].getName()));
    }
}
