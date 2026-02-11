package uz.pdp.springboot_module.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class ErrorDto {
    private Integer errorCode;
    private String errorPath;
    @JsonProperty("error_datails")
    private Object errorDetails;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
