package world.ucode.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import world.ucode.CRUD.UserDAO;
import world.ucode.Model.NewUserDTO;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class CreateLot {
    @RequestMapping(value = "/createLot", method = RequestMethod.GET)
    public String getPage() {
        return "/createLot";
    }
    @RequestMapping(value = "/createLot", method = RequestMethod.POST)
    public String createLot(@NotNull NewUserDTO user) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.getConnection();
        if (userDAO.create(user.getLogin(), user.getPassword(), user.getBalance(), user.getUserRole(),user.getEmail())) {
            return "/mainPage";
        }
        else {
            return "/signIn";
        }
    }
}
