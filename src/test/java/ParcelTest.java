import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {

  @Test
  public void newParcel_instantiatesCorrectly() {
    Parcel testParcel = new Parcel (2, 3, 5, 15);
    assertEquals(true, testParcel instanceof Parcel);
  }

  @Test
  public void getVolume_findsVolume() {
    Parcel testParcel = new Parcel (2, 3, 2, 14);
    assertEquals(12, testParcel.getVolume());
  }

  @Test
  public void getShipCost_findsCostToShip() {
    Parcel testParcel = new Parcel (12, 24, 5, 80);
    assertEquals(32.40, testParcel.getShipCost(1000, "Overnight"), 0.001);
  }
}
