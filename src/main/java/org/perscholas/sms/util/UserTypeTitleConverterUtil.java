package org.perscholas.sms.util;

import org.perscholas.sms.entity.UserTypeTitle;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserTypeTitleConverterUtil implements AttributeConverter<UserTypeTitle, String> {


    @Override
    public String convertToDatabaseColumn(UserTypeTitle userTypeTitle) {

        if (userTypeTitle == null) {
            return null;
        }
        return userTypeTitle.getRole();
    }

    @Override
    public UserTypeTitle convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }

        return Stream.of(UserTypeTitle.values())
                .filter(ut -> ut.getRole().equals(role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
