package world.ucode.Controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import world.ucode.CRUD.LotCRUD;
import world.ucode.Model.LotDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@Controller
public class CreateLot {
    @RequestMapping(value = "/createLot", method = RequestMethod.GET)
    public String getPage() {
        return "/createLot";
    }
    @RequestMapping(value = "/createLot", method = RequestMethod.POST)
    public void getData(Lot lot) throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LotCRUD lotcr = new LotCRUD();
        lotcr.getConnection();
        lot.setActive(0);
        lotcr.create(lot.getTitle(), lot.getStartPrice(), lot.getBidStep(), lot.getDuration(), lot.getDescription(), lot.getCategory(), lot.getStartTime(), lot.getFinishTime(), lot.getActive());
        JSONObject res = lotcr.getData();
        System.out.println(res);
    }
}
