package celik.cqrsWithCleanArchitectureTwo.persistance;


import celik.cqrsWithCleanArchitectureTwo.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType,String> {

}
