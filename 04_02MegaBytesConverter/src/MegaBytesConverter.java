public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if (kiloBytes<0) {
            System.out.println("Invalid Value");
        } else {
            int x = kiloBytes;
            int y=kiloBytes/1024;
            int z=kiloBytes%1024;

            //sout XX KB = YY MB and ZZ KB
            System.out.println(x+" KB = "+y+" MB and "+z+" KB");
        }
    }
}
