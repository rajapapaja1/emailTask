package dev.ante.email.dto;

import dev.ante.email.common.ImportanceEnum;
import dev.ante.email.validator.CCEmailValid;
import dev.ante.email.validator.EmailValid;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmailDTO {

    @EmailValid(message = "invalid from address")
    private String from;

    @EmailValid(message = "invalid to address")
    private String to;

    @CCEmailValid
    private String cc;

    @NotNull(message = "subject is required")
    @Size(min = 1, message = "subject field is empty")
    private String subject;

    @NotNull(message = "importance is required")
    private ImportanceEnum importance;

    @NotNull(message = "emailContent is required")
    @Size(min = 1, message = "emailContent field is empty")
    private String emailContent;
}
