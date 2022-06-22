package model.util;

import java.text.ParseException;
import model.database.dao.EmailUsuarioDAO;
import model.database.dao.UsuarioDAO;

/**
 *
 * @author lieds
 */
public class Login {    
    
    public boolean validateInfo(String email, String senha) throws ParseException {
        int user_id;       
        
        if(this.isEmailExist(email)) {
             user_id = new EmailUsuarioDAO().selectUserIdByEmail(email);
            if(isPasswordCorrect(user_id, senha)) {
                return true;
            }
        }
        
        return false;
    }        
    
    private boolean isEmailExist(String email) {
        boolean isEmailExists = new EmailUsuarioDAO().isUserEmailExists(email);        
        return isEmailExists;
    }
    
    private boolean isPasswordCorrect(int id_usuario, String password) throws ParseException {
        boolean isPasswordCorrect = false;
        String pass = new UsuarioDAO().getSenhaUsuarioById(id_usuario);        
        
        if (pass.equals(password)) {
            return true;
        }        
        
        return false;
    }
        
}
