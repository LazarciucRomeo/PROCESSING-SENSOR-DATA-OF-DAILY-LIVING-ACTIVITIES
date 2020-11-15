package Start;

import Model.FileTXT;
import Model.MonitoredData;
import Tasks.Task;

import java.io.IOException;
import java.util.ArrayList;


public class MainClass {
    public static void main(String[] args) throws IOException {
        FileTXT read=new FileTXT();
        Task task= new Task();
        task.Task_1();
        task.Task_2( read.ReadFile());
        task.Task_3(read.ReadFile());
    }
}
