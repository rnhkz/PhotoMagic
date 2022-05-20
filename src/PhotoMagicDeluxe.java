import java.util.Scanner;

public class PhotoMagicDeluxe {
    private final String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private Scanner kb = new Scanner(System.in);
    public static void main(String[] args){
        PhotoMagicDeluxe p = new PhotoMagicDeluxe();
        p.begin();
    }

    private void begin(){
        System.out.print("Enter File Name: ");
        String filename = kb.nextLine();
        System.out.print("Enter Password: ");
        String password = kb.nextLine();
        StringBuilder binaryString = new StringBuilder();
        for(int x = 0; x < password.length(); x++){
            binaryString.append(PhotoMagic.bitFormat(base64.indexOf(password.charAt(x)), 6));
        }
        Picture test2 = PhotoMagic.transform(new Picture(filename+".png"), new LFSR(binaryString.toString(), 58));
        test2.show();
    }
}
