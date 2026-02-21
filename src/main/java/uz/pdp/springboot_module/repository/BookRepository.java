package uz.pdp.springboot_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springboot_module.entity.Book;
import uz.pdp.springboot_module.payload.GetBookDTO;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.name = ?1")
    Optional<Book> findBookByName(String name);

    List<Book> findByYearBetween(Integer yearAfter, Integer yearBefore);

    List<Book> findAllByNameIgnoreCaseStartingWithAndPriceGreaterThan(String name, Double price);

    @Query("select new uz.pdp.springboot_module.payload.BookDTO(b.id, b.name, b.author)  from Book b where b.name ilike %:name%")
//    @Query(value = "select b.id as id, b.name as name, b.author as author from books b where b.name ilike concat('%', :name, '% ')", nativeQuery = true)
    List<GetBookDTO> getBooksByName(@Param("name") String name);
}
