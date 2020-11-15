package Tasks;

import Model.FileTXT;
import Model.MonitoredData;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;


public class Task {
    FileTXT task = new FileTXT();

    public void Task_1() throws IOException {


        task.WriteFile("Task_1.txt", task.ReadFile());
    }

    public void Task_2(ArrayList<MonitoredData> Data) throws IOException {
        String[] ziua;
        String[] data;
        ArrayList<String> list =new ArrayList<>();
        for (MonitoredData str : Data) {
            ziua = str.getStart_time().split(" ");
            data = ziua[0].split("-");
            list.add(data[2]);
        }
        int nrzile= (int) list.stream().distinct().count();

        Writer wr = new FileWriter("Task_2.txt");
        wr.write(valueOf(nrzile));
        wr.close();
    }

    public void Task_3(ArrayList<MonitoredData> Data) throws IOException {

        FileTXT task = new FileTXT();
        Map<String, Integer> hashMAP=Data.stream()
                    .collect(Collectors.groupingBy(MonitoredData::getActivity_label,
                            Collectors.reducing(0,e->1,Integer::sum)));

        System.out.println(hashMAP);
        task.WriteFile3("Task_3.txt",  hashMAP);
            }
}



