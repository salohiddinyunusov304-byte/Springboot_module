package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.payload.GetBookDTO;

import java.util.List;

public interface BookService {
    BookResponse createBook(BookCreator creator);

    List<BookResponse> findAllBooks();

    BookResponse findById(Integer id);

    void deleteById(Integer id);

    BookResponse update (Book book);

    BookResponse findByName(String name);

    List<BookResponse> findByYearBetween(Integer startYear, Integer endYear);

    List<BookResponse> findByParams(String name, Double price);

    List<GetBookDTO> getBooksByName(String name);
}
