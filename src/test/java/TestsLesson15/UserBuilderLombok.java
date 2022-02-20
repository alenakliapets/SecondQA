package TestsLesson15;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class UserBuilderLombok {
        String firstname;
        String lastname;
        String email;
        boolean emailNotifications;
        String language;
        String password;
    }

