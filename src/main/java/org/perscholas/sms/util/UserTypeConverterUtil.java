package org.perscholas.sms.util;

import org.perscholas.sms.entity.UserType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserTypeConverterUtil implements AttributeConverter<UserType, String> {


    @Override
    public String convertToDatabaseColumn(UserType userType) {

        if (userType == null) {
            return null;
        }
        return userType.getCapName();
    }

    @Override
    public UserType convertToEntityAttribute(String capName) {
        if (capName == null) {
            return null;
        }

        return Stream.of(UserType.values())
                .filter(ut -> ut.getCapName().equals(capName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
