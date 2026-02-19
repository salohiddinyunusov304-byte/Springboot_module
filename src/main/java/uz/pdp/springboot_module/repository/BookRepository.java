package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springboot_module.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.name = ?1")
    Optional<Book> findBookByName(String name);

    List<Book> findByYearBetween(Integer yearAfter, Integer yearBefore);
}
