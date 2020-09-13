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
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test cases for Drone")
public class DroneTest {

    @Test
    @DisplayName("Should execute the delivery routes successfully with tracking report")
    public void testExecuteDeliveryRoutes() throws IOException, InterruptedException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines("src/test/resources/robots/in01.txt");

        List<List<MovementType>> deliveryRoutes = fileLines.stream()
                .map(MovementTypeUtil::stringToMovementType)
                .collect(Collectors.toList());

        Robot drone = new Drone("01", deliveryRoutes);

        drone.call();
        List<CartesianPosition> tracking = drone.getTracking();

        assertEquals(3, tracking.size());
        assertEquals("(-2, 4) O", tracking.get(0).toString());
        assertEquals("(-1, 3) S", tracking.get(1).toString());
        assertEquals("(0, 0) O", tracking.get(2).toString());
    }
}
