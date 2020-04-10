package scpjavaproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import scpjavaproject.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
