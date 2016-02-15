import java.text.DecimalFormat;

public class Parcel {
  private int mHeight;
  private int mWidth;
  private int mLength;
  private int mWeight;

  public Parcel (int height, int width, int length, int weight) {
    mHeight = height;
    mWidth = width;
    mLength = length;
    mWeight = weight;
  }

  public int getVolume() {
    return mHeight * mWidth * mLength;
  }

  public String getShipCost(int mileage, String speed, String giftwrap) {
    double shipCost = (getVolume() * .005 + mWeight * .05) * mileage * .002;
    if (speed.equals("Overnight")) {
      shipCost +=10;
    } else if (speed.equals("Express")) {
      shipCost +=5;
    }
    if (giftwrap.equals("yes")) {
      shipCost = shipCost + (2 * mHeight * mWidth + 2 * mWidth * mLength + 2 * mHeight * mLength)/144;
    }
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(shipCost);
  }
}
