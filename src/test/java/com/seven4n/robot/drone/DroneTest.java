package com.seven4n.robot.drone;

import com.seven4n.util.MovementTypeUtil;
import com.seven4n.util.file.FileExternalSourceType;
import com.seven4n.util.file.read.ReadExternalFile;
import com.seven4n.util.file.read.ReadFileFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Test cases for read file factory")
public class DroneTest {

    @Test
    @DisplayName("Should retrieve the file and match its content")
    public void testGetReadExternalFile() throws IOException, URISyntaxException {
        ReadExternalFile fileReader = ReadFileFactory.getReadExternalFile(FileExternalSourceType.LOCAL_FILE);
        List<String> fileLines = fileReader.readByLines("src/test/resources/in01.txt");

        List<List<MovementType>> deliveryRoutes = fileLines.stream()
                .map(MovementTypeUtil::stringToMovementType)
                .collect(Collectors.toList());

        Drone drone = new Drone("01", deliveryRoutes);

        Thread thread = new Thread(drone);
        thread.start();

        System.out.println(drone.getDeliveryPointsReport());
    }
}
