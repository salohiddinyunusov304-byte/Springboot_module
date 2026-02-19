package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.service.BookService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = Constants.BASE_URL + "/books";
    private final BookService bookService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse createBook(@RequestBody BookCreator creator) {
        return bookService.createBook(creator);
    }

    @GetMapping("/findAll")
    public List<BookResponse> findAllBook() {
        return bookService.findAllBooks();
    }

    @GetMapping("/findById/{id}")
    public BookResponse findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public BookResponse findByName(@PathVariable String name) {
        return bookService.findByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateById(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping("/findByYear")
    public List<BookResponse> findByYear(
            @RequestParam Integer startYear,
            @RequestParam Integer endYear
    ) {
        return bookService.findByYearBetween(startYear, endYear);
    }

}
