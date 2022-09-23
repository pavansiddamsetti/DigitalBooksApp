package com.digitalbook.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalbook.models.BookDetails;


@Repository
public interface BookRepository extends JpaRepository<BookDetails,Serializable>{
	
	@Query(value = "select * from Book_details where title=:title or author_name=:authorName or publisher=:publisher or release_date=:rdate",nativeQuery = true)
	List<BookDetails> findByBooks(@Param("title") String title,@Param("authorName")String authorName,@Param("publisher") String publisher,@Param("rdate") LocalDate rdate);

	@Transactional
	@Modifying
	@Query(value = "update book_details b set title=:title,category=:category,price=:price,author_name=:author,publisher=:publisher,release_date=:rdate,book_status=:active where b.book_id=:bid and b.author_id=:aid", nativeQuery = true)
	int editBookDetails(@Param("title") String title, @Param("category")String category ,@Param("price") float price,@Param("author") String author,@Param("publisher") String publisher,@Param("rdate") LocalDate localDate,@Param("active") boolean active,@Param("bid") int bid,@Param("aid") int aid);
	
	@Transactional
		@Modifying()
		@Query(value = "update book_details b set book_blocked=false where b.book_id=:bid and b.author_id=:aid", nativeQuery = true)
		int blockBookDetails(@Param("bid") int bid,@Param("aid") int aid);
}
