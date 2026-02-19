package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.repository.BookRepository;
import uz.pdp.springboot_module.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookService bookService;

    @Override
    public BookResponse createBook(BookCreator creator) {
        Book book = Book.builder()
                .name(creator.name())
                .author(creator.author())
                .year(creator.year())
                .price(creator.price())
                .pages(creator.pages())
                .build();
        Book save = bookRepository.save(book);
        return new BookResponse(
                save.getId(),
                save.getName(),
                save.getAuthor(),
                save.getYear(),
                save.getPrice(),
                save.getPages()
        );
    }

    @Override
    public List<BookResponse> findAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                ))
                .toList();
    }

    @Override
    public BookResponse findById(Integer id) {
        return bookRepository.findById(id)
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                ))
                .orElse(null);
//        Optional<Book> byId = bookRepository.findById(id);
//        if (byId.isPresent()) {
//            Book book = byId.get();
//            return new BookResponse(
//                    book.getId(),
//                    book.getName(),
//                    book.getAuthor(),
//                    book.getYear(),
//                    book.getPrice(),
//                    book.getPages()
//            );
//        } else {
//            return null;
//        }
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse update(Book book) {
        Book save = bookRepository.save(book);
        return new BookResponse(
                save.getId(),
                save.getName(),
                save.getAuthor(),
                save.getYear(),
                save.getPrice(),
                save.getPages()
        );
    }

    @Override
    public BookResponse findByName(String name) {
//        Optional<Book> optionalBook = bookRepository.findBookByName(name);
//        if (optionalBook.isPresent()) {
//            Book book = optionalBook.get();
//            return new BookResponse(
//                    book.getId(),
//                    book.getName(),
//                    book.getAuthor(),
//                    book.getYear(),
//                    book.getPrice(),
//                    book.getPages()
//            );
//        } else {
//            return null;
//        }
        return bookRepository.findBookByName(name)
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                ))
                .orElse(null);
    }

    @Override
    public List<BookResponse> findByYearBetween(Integer startYear, Integer endYear) {
        List<Book> byYearBetween = bookRepository.findByYearBetween(startYear, endYear);
        return byYearBetween.stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getName(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getPrice(),
                        book.getPages()
                )).toList();
    }
}
