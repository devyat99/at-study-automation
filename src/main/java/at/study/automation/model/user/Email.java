package at.study.automation.model.user;


import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import lombok.Getter;
import lombok.Setter;

import static at.study.automation.utils.StringUtils.randomEmail;

@Setter
@Getter
public class Email extends CreatableEntity implements Creatable<Email> {

    private Integer userId;
    private String address = randomEmail();
    private Boolean isDefault = true;
    private Boolean notify = true;

    public Email(User user) {
        this.userId = user.getId();
        user.getEmails().add(this);
    }


    @Override
    public Email create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }
}
