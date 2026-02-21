package uz.pdp.springboot_module.payload;

import uz.pdp.springboot_module.entity.Group;

public record StudentCreator(
        Integer groupId,
        String firstName,
        String lastName,
        Integer birthYear
) {}
