package uz.pdp.springboot_module.entity_domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Book {
    private Integer id;
    private String title;
    private String author;
}
