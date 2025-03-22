import io.github.vishva_kalhara.data_port.DataPort;
import io.github.vishva_kalhara.data_port.util.FileHandler;

import java.awt.*;

public class Test extends Component {

    Test(){
        try {

            String path = "C:/Program Files/MySQL/MySQL Server 8.0/bin/mysql.exe";
            System.out.println(path);

            boolean isSuccess = new DataPort(
                    "root",
                    "Wishva!23",
                    "school_sync",
                    path
            ).create();
            System.out.println(isSuccess);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        new Test();
    }
}
