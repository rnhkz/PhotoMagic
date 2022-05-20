import java.awt.*;
import java.util.ArrayList;

public class PhotoMagic {
    public static void main(String[] args){
        Picture test = transform(new Picture("New.png"), new LFSR("01101000010100010000", 16));
        test.show();
    }

    static Picture transform(Picture pic, LFSR lfsr){
        for(int y = 0; y < pic.height(); y++){
            for(int x = 0; x < pic.width(); x++){
                Color c = pic.get(x,y);
                ArrayList<Integer> rgb = new ArrayList<>();
                String[] RGB = {bitFormat(c.getRed(), 8),
                                bitFormat(c.getGreen(), 8),
                                bitFormat(c.getBlue(), 8)};
                for(String val : RGB) {
                    String toCompare = bitFormat(lfsr.generate(8), 8);
                    StringBuilder binaryString = new StringBuilder();
                    for(int pos = 0; pos < 8; pos++)
                        binaryString.append(val.charAt(pos) ^ toCompare.charAt(pos));
                    rgb.add(Integer.parseInt(binaryString.toString(),2));
                }
                pic.set(x, y, new Color(rgb.get(0),rgb.get(1),rgb.get(2)));
            }
        }
        return pic;
    }

    static String bitFormat(int decimal, int size){
        return "0".repeat(Math.max(0, size - Integer.toBinaryString(decimal).length())) + Integer.toBinaryString(decimal);
    }
}