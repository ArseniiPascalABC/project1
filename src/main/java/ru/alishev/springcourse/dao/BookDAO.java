package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;
import java.util.Optional;
@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny();
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(title, release_year, author) VALUES(?, ?, ?)", book.getTitle(),
                book.getRelease_year(), book.getAuthor());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, release_year=?, author=? WHERE id=?", updatedBook.getTitle(),
                updatedBook.getRelease_year(), updatedBook.getAuthor(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }

    public Optional<Person> getBookOwner(int id){
        return jdbcTemplate.query("SELECT person.* FROM book JOIN Person ON book.person_id = person.id "+
                "WHERE book.id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public void release(int id){
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE id=?", id);
    }

    public void assign(int id, Person selectedPerson){
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE id=?", selectedPerson.getId(), id);
    }
}
