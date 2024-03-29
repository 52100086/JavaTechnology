package tdtu.edu.Lab9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab9.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Modifying
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName where u.id = :id")
    void updateName(@Param("id") Integer id, @Param("firstName") String firstName, @Param("lastName") String lastName);

}
