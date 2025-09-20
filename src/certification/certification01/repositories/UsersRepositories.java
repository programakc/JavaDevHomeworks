package certification.certification01.repositories;

import certification.certification01.model.User;

import java.util.List;

public interface UsersRepositories {

    abstract void create (User user);
    abstract User findById (String id);
    abstract List<User> findAll();
    abstract void update (User user);
    abstract void deleteById (String id);
    abstract void deleteAll();
}
