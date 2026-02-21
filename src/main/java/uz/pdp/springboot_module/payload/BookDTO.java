package uz.pdp.springboot_module.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer id;
    private String name;
    private String author;

}
