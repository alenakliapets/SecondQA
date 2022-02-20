package TestsLesson15;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode //Или вместо всего этого @Data
@RequiredArgsConstructor
public class UserLombok {
    @NonNull
    String firstname;
    @NonNull
    String lastname;
    String email;
    boolean emailNotifications;
    String language;
    String password;

}
