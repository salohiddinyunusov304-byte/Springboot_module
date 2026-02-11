package uz.pdp.springboot_module.payload;

import java.util.concurrent.atomic.AtomicInteger;

public record Todo (
    Integer id,
    String title,
    Integer priority
) {
}
