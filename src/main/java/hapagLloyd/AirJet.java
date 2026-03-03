package hapagLloyd;

import java.io.IOException;

public class AirJet extends AeroPlane {

    public int data = 9;

    public AirJet() throws IOException {
        System.out.println("Airjet child");
//        try {
//            super();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
