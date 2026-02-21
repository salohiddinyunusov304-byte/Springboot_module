package uz.pdp.springboot_module.payload;

import uz.pdp.springboot_module.entity.Group;

public record StudentResponse(
        Integer id,
        Group group,
        String firstName,
        String lastName,
        Integer birthYear
) {
}
