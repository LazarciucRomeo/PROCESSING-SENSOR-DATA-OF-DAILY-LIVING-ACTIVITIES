package Model;

import java.io.Serializable;

public class MonitoredData implements Serializable {
    private String start_time;
    private String end_time;
    private String activity_label;
    public MonitoredData(String start_time, String end_time, String activity_label){
        this.start_time=start_time;
        this.end_time=end_time;
        this.activity_label=activity_label;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getActivity_label() {
        return "\n"+ activity_label;
    }

    @Override
    public String toString() {
        return "MonitoredData{" +
                "start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", activity_label='" + activity_label + '\'' +
                '}'+"\n";
    }
}
