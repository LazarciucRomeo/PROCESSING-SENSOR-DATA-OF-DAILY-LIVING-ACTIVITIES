package Model;



import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class FileTXT {


    public ArrayList<MonitoredData> ReadFile(){
        String fileName="Activities.txt";
        ArrayList<MonitoredData> lista =new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

         lista= (ArrayList<MonitoredData>) stream.map(line -> line.split("\t\t"))
                    .map(a -> new MonitoredData(a[0], a[1], a[2]))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  lista;
    }
    public void WriteFile(String fileName, ArrayList<MonitoredData> Data) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        DataOutputStream oos =new DataOutputStream(outputStream );
        oos.writeUTF(Data.toString());
        oos.close();

        outputStream.close();

    }
    public void WriteFile3(String fileName, Map<String,Integer> hashMap) throws IOException {
        try {
        FileOutputStream outputStream = new FileOutputStream(fileName);
     ObjectOutputStream oos =new ObjectOutputStream(outputStream );
        oos.writeObject(hashMap.toString());
        oos.flush();
        oos.close();
        outputStream.close();
        } catch(Exception e) {}

    }
}
