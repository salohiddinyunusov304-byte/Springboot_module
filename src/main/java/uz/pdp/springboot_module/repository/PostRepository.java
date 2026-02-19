package uz.pdp.springboot_module.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.springboot_module.entity.Post;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    // way - 1
//    @Query("select p from Post p") // jpql query

    // way - 2
//    @Query(nativeQuery = true, value = "select * from posts") // native query
//    @Query(name = "Posts.getAllPosts")

    @Query(
            nativeQuery = true,
            value = "select * from posts",
            countQuery = "select count(*) from posts"
    )
    Page<Post> getAllPosts(Pageable pageable);

    @Query("select p from Post p where p.userId = ?1")
    List<Post> getPostsByUserId(Integer userId, Sort sort);

    List<Post> findAllByUserId(Integer userId, Sort sort);

    List<Post> findAllByUserIdIn(Collection<Integer> userId, Sort sort);
}
