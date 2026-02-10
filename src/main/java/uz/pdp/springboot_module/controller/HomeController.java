package uz.pdp.springboot_module.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.springboot_module.payload.BookCreator;
import uz.pdp.springboot_module.payload.BookResponse;
import uz.pdp.springboot_module.service.BookService;

import java.util.List;

@Controller
@RequiredArgsConstructor // dependency injection uchun
public class HomeController {

//    @Value("${g58.message}")

    private final BookService bookService;


    @GetMapping("/")
    public String home(Model model) {
        List<BookResponse> books = bookService.findAll();
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping("/create-book")
    public String createBookGetPage() {
        return "create-book";
    }
    @PostMapping("/create-book")
    public String createBook(@ModelAttribute BookCreator creator) {
        bookService.createBook(creator);
        return "redirect:/";
    }
}

