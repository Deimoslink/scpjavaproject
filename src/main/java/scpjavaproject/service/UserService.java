package scpjavaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import scpjavaproject.model.User;
import scpjavaproject.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    private List<User> users = new ArrayList<>(Arrays.asList(
//            new User("1", "Flynn", "Taggard", "DOOMGUY", "password"),
//            new User("2", "William", "Blazkowicz", "BJBLAZKO", "password"),
//            new User("3", "Ranger", "Bitterman", "QUAKE", "password"),
//            new User("4", "Gordon", "Freeman", "PONYTAIL", "password"),
//            new User("5", "Booker", "DeWitt", "LISASHOCK", "password"),
//            new User("6", "Morgan", "Yu", "TYPHON", "password")
//    ));


    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

}
