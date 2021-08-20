package steps;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.*;

class CSVFile {

    private List<String[]> records;

    //constants for sortDirection
    final public int SortASC = 1;
    final public int SortDESC = -1;
    private int sortDirection = SortASC; //1 for ASC, -1 for DESC
    String fileName;
    String newFileName;

    private int colsCount;

    public CSVFile(String fileName) throws IOException{
        records = new ArrayList<>();
        this.fileName = "src/main/resources/files/CsvFile.csv";
        this.newFileName = "src/main/resources/files/newCsvFile.csv";
        try(BufferedReader in = new BufferedReader(new FileReader(this.fileName)))
        {
            String ln;
            while( (ln = in.readLine()) !=null) {
                colsCount = ln.split("\t").length; //FIXME
                records.add(ln.split("\t"));
            }
        }
    }

    public void printNewCSV(){
        try {
            CSVReader reader = new CSVReader(new FileReader(newFileName));
            reader.iterator();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[0]);
            }
        }catch (Exception e){
            System.out.println("Произошла ошибка во время парсинга CSV\n");
            e.printStackTrace();
        }
    }

    public void save() throws IOException{
        try(BufferedWriter out = new BufferedWriter(new FileWriter(newFileName)))
        {
            for(String[] arr : records){
                for (String s :arr) {
                    out.write(s+"   ",8,4);
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

}



