package com.slawomir_aleksak.spring_second_project.data;

import com.slawomir_aleksak.spring_second_project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// public class BooksRepository {
    
// }
public interface BooksRepository extends JpaRepository<Book, Long> {
    
}