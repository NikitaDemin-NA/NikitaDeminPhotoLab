package steps;

import java.io.*;
import java.util.*;

class CSVFile {

    private List<String[]> records;

    //constants for sortDirection
    final public int SortASC = 1;
    final public int SortDESC = -1;
    private int sortDirection = SortASC; //1 for ASC, -1 for DESC
    String fileName;

    private int colsCount=0;

    public CSVFile(String fileName) throws IOException{
        records = new ArrayList<>();
        this.fileName = "src/main/resources/files/CsvFile.csv";
        try(BufferedReader in = new BufferedReader(new FileReader(this.fileName)))
        {
            String ln;
            while( (ln = in.readLine()) !=null) {
                colsCount = ln.split("\t").length; //FIXME
                records.add(ln.split("\t"));
            }
        }
    }

    public void print(){
        for(String[] arr : records){
            for (String s:arr) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }
    }

    public void save() throws IOException{
        try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName)))
        {
            for(String[] arr : records){
                for (String s:arr) {
                    out.write(s+"\t");
                }
                out.write("\n");
            }
        }
    }

    public void setSortDirection(int direction){
        sortDirection = direction;
    }

    public void sortByCol(final int i){

        //comparator by specific col
        Comparator<String[]> comp = (a, b) -> {
            //reverse result if DESC (sortDirection = -1)
            return sortDirection * a[i].compareTo(b[i]);
        };

        records.sort(comp);
    }

    public int getColsCount(){
        return colsCount;
    }
}



class SortCSV {
    private static BufferedReader in;

    private static String fileName;

    public static void main(String args[]) throws IOException{

        in = new BufferedReader(new InputStreamReader(System.in));
        if (args.length<1){
            //promt user for input file
            System.out.println("Enter path to .CSV file: ");
            fileName = in.readLine();
        } else
        {
            fileName = args[0];
        }

        try {
            CSVFile csv = new CSVFile(fileName);


            csv.print();

            int maxcol = csv.getColsCount();
            System.out.println(
                    String.format("Select sorting column (1-%d): [1] ",maxcol));

            int sortCol = 1;
            String res =in.readLine();

            //if non-default
            if (res.trim().length() != 0){
                sortCol = Integer.parseInt(res);
                if ((sortCol<1) || (sortCol >maxcol)){
                    System.out.println("Incorect column number");
                    System.exit(0);
                }
            }

            String sortDirection = "1";
            System.out.println("Select sort direction");
            System.out.println("1. ASC");
            System.out.println("2. DESC");
            System.out.print("[1]:");
            sortDirection = in.readLine();
            if (sortDirection == "2")
                csv.setSortDirection(csv.SortDESC);

            csv.sortByCol(sortCol-1); //-1 map from 1:n to 0:n-1
            csv.save();
            System.out.println("Sorted and saved to file");
            System.out.println("Would you like to see result before exit? (yes/no)[no]");
            if (in.readLine().trim().equals("yes"))
                csv.print();
        } catch(IOException e) {
            System.out.println("File doesn't exist");
            System.exit(0);
        }
    }
}