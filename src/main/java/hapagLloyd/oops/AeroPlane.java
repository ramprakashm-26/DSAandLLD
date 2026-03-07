package hapagLloyd.oops;

import java.io.IOException;

public class AeroPlane {

    public int data = 0;

    public AeroPlane() throws IOException {
        System.out.println("Aero parent");
        throw new IOException();
    }
}
