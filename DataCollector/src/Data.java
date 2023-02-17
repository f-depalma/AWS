import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    Date date;
    String name;
    float value;
    String unit;

    public Data(String json) throws ParseException {
        //System.out.println(json);
        List<String[]> data = Arrays.stream(json.replace("{", "")
                        .replace("}", "")
                        .replace(": ", ":")
                        .replace("\"", "")
                        .replace(",", "")
                .split("    ")).map(x -> x.split(":")).toList();

        //System.out.println(data);
        for (String[] single_data : data) {
            switch (single_data[0]) {
                case "date_time":
                    this.date = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss").parse(single_data[1]);
                    break;
                case "name":
                    this.name = single_data[1];
                    break;
                case "value":
                    this.value = Float.valueOf(single_data[1]);
                    break;
                case "unit":
                    this.unit = single_data[1];
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Data{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }
}
