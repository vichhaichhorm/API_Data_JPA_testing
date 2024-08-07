package com.example.demo_data_jpa_using_hibernate.repository;

import com.example.demo_data_jpa_using_hibernate.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book , String> {

}
