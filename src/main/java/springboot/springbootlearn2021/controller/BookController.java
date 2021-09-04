package springboot.springbootlearn2021.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.springbootlearn2021.comment.Result;
import springboot.springbootlearn2021.entity.Book;
import springboot.springbootlearn2021.service.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Object books() {
        List<Book> books = bookService.getBooks();
        return JSON.toJSON(books);
    }

    @PostMapping("/bookCategory")
    public Result<JSON> bookCategory() {
        List<String> bookCategory = bookService.getBookCategory();
        return Result.ok(JSON.toJSON(bookCategory));
    }

    @DeleteMapping("/deleteBook/{id}")
    public Object deleteBook(@PathVariable Integer id) {
        System.out.println("正在删除：" + id);
        return bookService.delete(id);
    }

    @PutMapping("/updateBook")
    public Object updateBook(Book book) {
        return bookService.update(book);
    }
}
