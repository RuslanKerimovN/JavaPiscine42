package ex02;

public interface UsersList {
    void addingUsers(User user);
    User getUserById(Integer id) throws UserNotFoundException;
    User getUserByIndex(int index);
    Integer valueUsers();
}
