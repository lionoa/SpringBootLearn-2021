package springboot.springbootlearn2021.service;

import org.springframework.stereotype.Service;
import springboot.springbootlearn2021.entity.Book;

import java.util.List;

@Service
public interface BookService {
    /**
     * 获取所有图书
     * @return
     */
    List<Book> getBooks();

    /**
     * 获取所有图书类别
     * @return
     */
    List<String> getBookCategory();

    /**
     * 按 id 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 通过 id 修改书籍
     * @param book
     * @return
     */
    int update(Book book);
}
