package springboot.springbootlearn2021.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import springboot.springbootlearn2021.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * 获取所有书籍
     */
    @Select("select * from book;")
    public List<Book> getBooks();

    @Select("select distinct bookCategory from book where bookCategory is not null;")
    public List<String> getBookCategory();

    @Delete("delete from book where bookId = #{bookId}")
    public int delete(Integer id);

    @Update("update book set bookName = #{bookName}," +
            "bookAuthor = #{bookAuthor}," +
            "bookPublish = #{bookPublish}," +
            "bookCategory = #{bookCategory}," +
            "bookPrice = #{bookPrice}," +
            "bookIntroduction = #{bookIntroduction} " +
            "where bookId = #{bookId}")
    public int update(Book book);
}
