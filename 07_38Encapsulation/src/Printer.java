public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100)
            this.tonerLevel = tonerLevel;
        else this.tonerLevel = -1;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if(tonerAmount+tonerLevel>100)
                return tonerLevel=-1;
            else return tonerLevel+=tonerAmount;

        }else return tonerLevel=-1;

    }
    public int printPages(int pages){
        int pagesToPrint=duplex?pages/2+pages%2: pages;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}