public class BreakPhotoMagic {
    public static void main(String[] args){
        BreakPhotoMagic b = new BreakPhotoMagic();
        b.begin();
    }

    private void begin() {
        String title = "mystery";
        Picture p = new Picture(title+".png");
        for(int x = 0; x < Math.pow((title.length()*8), 2); x++){
            for(int y = 0; y < title.length()*8; y++) {
                Picture decrypt = PhotoMagic.transform(p, new LFSR(PhotoMagic.bitFormat(x, title.length()*8), y));
            }
        }
    }
}
