package uz.pdp.springboot_module.payload;

public record BookResponse(
        Integer id,
        String name,
        String author,
        Integer year,
        Double price,
        Integer pages
) {
}
