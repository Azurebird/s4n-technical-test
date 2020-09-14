package com.seven4n.robot.drone;

import com.seven4n.robot.CartesianPosition;
import com.seven4n.robot.MovementType;
import com.seven4n.robot.Robot;
import com.seven4n.robot.util.MovementTypeUtil;
import com.seven4n.util.file.FileExternalSourceType;
import com.seven4n.util.file.read.ReadExternalFile;
import com.seven4n.util.file.read.ReadFileFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test cases for Drone")
public class DroneTest {

    @Test
    @DisplayName("Should execute the delivery routes successfully with tracking report")
    public void testExecuteDeliveryRoutes() throws IOException, InterruptedException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines("src/test/resources/robots/in/in01.txt");

        List<List<MovementType>> deliveryRoutes = MovementTypeUtil.stringListToMovementTypeList(fileLines);

        Robot drone = new Drone("01", deliveryRoutes, 10);

        drone.call();
        List<CartesianPosition> tracking = drone.getTracking();

        assertEquals(3, tracking.size());
        assertEquals("(-2, 4) dirección Oeste", tracking.get(0).toString());
        assertEquals("(-1, 3) dirección Sur", tracking.get(1).toString());
        assertEquals("(0, 0) dirección Oeste", tracking.get(2).toString());
    }

    @Test
    @DisplayName("Should finish the route before delivering all lunches since radius to short")
    public void testRadiusToShortToMakeFullRoute() throws IOException, InterruptedException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines("src/test/resources/robots/in/in01.txt");

        List<List<MovementType>> deliveryRoutes = MovementTypeUtil.stringListToMovementTypeList(fileLines);

        Robot drone = new Drone("01", deliveryRoutes, 3);

        drone.call();
        List<CartesianPosition> tracking = drone.getTracking();

        assertEquals(1, tracking.size());
        assertEquals("(0, 3) dirección Norte", tracking.get(0).toString());
    }
}
