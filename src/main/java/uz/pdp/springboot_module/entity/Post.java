package uz.pdp.springboot_module.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "posts")
// way - 3
//@NamedQuery(
//        name = "Posts.getAllPosts",
//        query = "select p from Post p"
//)

// way - 4
//@NamedNativeQuery(
//        name = "Posts.getAllPosts",
//        query = "select * from posts",
//        resultClass = Post.class
//)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String title;
    private String body;
}
