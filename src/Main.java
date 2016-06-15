import com.epam.gift.controller.Controller;
import com.epam.gift.model.Gift;
import com.epam.gift.view.View;

/**
 * Run class
 */
public class Main {

    public static void main(String[] args) {
        Gift gift = new Gift();
        View view = new View();

        Controller controller = new Controller(gift, view);

        //Run
        controller.processUser();
    }
}
