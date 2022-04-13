package celik.cqrsWithCleanArchitectureTwo.application.accountTypes.commands.create;

import celik.cqrsWithCleanArchitectureTwo.domain.AccountType;
import celik.cqrsWithCleanArchitectureTwo.persistance.AccountTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeEventHandler {

    private AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @EventHandler
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent){
        AccountType accountType=new AccountType();
        BeanUtils.copyProperties(accountTypeCreatedEvent,accountType);
        this.accountTypeRepository.save(accountType);
    }
}
