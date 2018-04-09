package example.dao;

import example.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davis
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
        
}
