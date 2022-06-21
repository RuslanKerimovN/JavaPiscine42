package ex04;

public class UsersArrayList implements UsersList {
    private User[] array;
    private static final float INCREANCE = 1.5f;
    private int quantityArrayObject = 0;

    UsersArrayList() {
        this.array = new User[10];
    }

    public User[] getArray() {
        return array;
    }

    public void setArray(User[] array) {
        this.array = array;
    }

    @Override
    public void addingUsers(User addUser) {
        User[] tmpArray = new User[0];

        if (array[array.length - 1] != null) {
            tmpArray = new User[(int) (array.length * INCREANCE)];
            for (int i = 0; i < array.length; i++) {
                tmpArray[i] = array[i];
            }
                tmpArray = findEmptyPisitionForUserAddAndAdding(tmpArray, addUser);
                array = tmpArray;
            }
        else {
            array = findEmptyPisitionForUserAddAndAdding(array, addUser);
        }
        quantityArrayObject++;
    }

    private User[] findEmptyPisitionForUserAddAndAdding(User[] array, User addUser) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = addUser;
                break;
            }
        }
        return array;
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        for (int i = 0; i < quantityArrayObject; i++) {
            if (array[i].getId() == id) {
                return array[i];
            }
        }
        throw new UserNotFoundException("User with id = " + id + " not found");
    }

    @Override
    public User getUserByIndex(int index) throws ArrayIndexOutOfBoundsException, IndexOutOfBoundsException {
        if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else if (index > quantityArrayObject - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public Integer valueUsers() {
        return quantityArrayObject;
    }

}
