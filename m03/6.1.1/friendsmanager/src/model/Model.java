
package model;

import java.sql.SQLException;
import model.persistence.FriendDAO;
import java.util.List;

public class Model {
    
    
    public Friend findById ( long id ) throws ClassNotFoundException {
        FriendDAO fd = new FriendDAO();
        return fd.findById(id);
    }
    
    public List<Friend> findByPhone ( String phone ) throws ClassNotFoundException {
        
        FriendDAO fd = new FriendDAO();
        List<Friend> result = fd.findByPhone(phone);
        return result;
    }
    
    public int addFriend ( Friend f ) throws ClassNotFoundException, SQLException {
        
        FriendDAO fd = new FriendDAO();
        int result = fd.insert(f);
        return result;
    }
    
    public int updateFriend ( Friend f ) throws ClassNotFoundException {
        FriendDAO fd = new FriendDAO();
        int result = fd.update(f);
        return result;
    }
    
    public int deleteFriend ( Friend f ) throws ClassNotFoundException {
        FriendDAO fd = new FriendDAO();
        int result = fd.delete(f);
        return result;
    }
    
}//end of class
