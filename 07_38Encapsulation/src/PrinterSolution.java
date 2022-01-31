public class PrinterSolution {
    public class Printer {

        private int  tonerLevel;
        private int pagesPrinted;
        private boolean duplex;

        public Printer(int tonerLevel, boolean duplex) {
            if(tonerLevel>-1 && tonerLevel<=100) {
                this.tonerLevel = tonerLevel;
            }
            else
            {
                this.tonerLevel=-1;
            }
            this.duplex = duplex;
            this.pagesPrinted=0;
        }

        public int addToner(int tonerAmount)
        {
            // if(tonerLevel>0 && tonerLevel<=100)
            if(tonerAmount>0 && tonerAmount<=100) // wrong variable
            {
                if(tonerAmount+tonerLevel<=100)
                {
                    tonerLevel+=tonerAmount;
                    return tonerLevel;
                }
                // else // unnecessary
                // {
                //     return -1;
                // }
            }
            // else // unnecessary
            return -1;
        }

        public int printPages(int pages)
        {
            if(tonerLevel < 0 ) return -1; // added validation
            int pagesToPrint=pages;
            if(duplex)
            {
                // pagesPrinted+=(pages/2)+(pages%2);
                pagesToPrint = (pages/2)+(pages%2); // wrong variable
            }
            // else
            // {
            pagesPrinted+=pagesToPrint;
            // }
            // return pagesPrinted;
            return pagesToPrint; // not pagesPrinted, which is the lifetime pages the printer has printed
        }

        public int getPagesPrinted() {
            return pagesPrinted;
        }
    }
}
