package IO.xlsx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor // добавлять и почитать про них
@NoArgsConstructor
public class Currency {

    private String numCode;
    private String charCode;
    private int scale;
    private String name;
    private double rate;
    private Date date;


}
