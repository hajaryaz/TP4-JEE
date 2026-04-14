package dao;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurImpl implements UtilisateurDAO {
    
    private static List<Utilisateur> utilisateurs = new ArrayList<>();
    private static Long compteur = 1L;
    
    // Initialisation avec des utilisateurs par défaut
    static {
        Utilisateur admin = new Utilisateur("admin_hajar", "admin123", "ADMIN");
        admin.setId(compteur++);
        utilisateurs.add(admin);
        
        Utilisateur user = new Utilisateur("user_hajar", "user123", "USER");
        user.setId(compteur++);
        utilisateurs.add(user);
    }
    
    @Override
    public Utilisateur findByLogin(String login) {
        for (Utilisateur u : utilisateurs) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public Utilisateur findByLoginAndPassword(String login, String password) {
        for (Utilisateur u : utilisateurs) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public List<Utilisateur> getAllUsers() {
        return utilisateurs;
    }
    
    @Override
    public void addUser(Utilisateur user) {
        user.setId(compteur++);
        utilisateurs.add(user);
    }
}