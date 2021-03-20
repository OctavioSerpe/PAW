package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDaoImpl implements UserDao{

    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public UserDaoImpl(){
        User user = new User();
        user.setId("1");
        user.setName("Leo");
        user.setPassword("1234");
        this.userMap.put(user.getId(), user);

        User user2 = new User();
        user2.setId("2");
        user2.setName("Alvaro");
        user2.setPassword("12345");
        this.userMap.put(user2.getId(), user2);

        User user3 = new User();
        user3.setId("3");
        this.userMap.put(user3.getId(), user3);
    }

    @Override
    public User get(String id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> list() {
        return new ArrayList<User>(this.userMap.values());
    }

    @Override
    public User save(User user) {
        return this.userMap.put(user.getId(), user);
    }
}
