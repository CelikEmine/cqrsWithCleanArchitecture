package celik.cqrsWithCleanArchitectureTwo.application.accountTypes.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateAccountTypeCommand {

    @TargetAggregateIdentifier
    private String accountTypeId;

    private String accountName;

    private String description;

    private double price;
}
