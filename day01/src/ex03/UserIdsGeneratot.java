package ex03;

public class UserIdsGeneratot {
    private static UserIdsGeneratot instance;
    private static Integer id = 0;

    private UserIdsGeneratot() {}

    public static UserIdsGeneratot getInstance() {
        if (instance == null) {
            instance = new UserIdsGeneratot();
        }
        return instance;
    }

    public int generateId() {
        return  id += 1;
    }
}
