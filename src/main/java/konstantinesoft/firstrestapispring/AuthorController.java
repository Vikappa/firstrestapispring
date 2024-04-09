package konstantinesoft.firstrestapispring;


import jakarta.websocket.server.PathParam;
import konstantinesoft.firstrestapispring.entities.Author;
import konstantinesoft.firstrestapispring.entities.BlogPost;
import konstantinesoft.firstrestapispring.services.AuthorService;
import konstantinesoft.firstrestapispring.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Specializzazione di @Component, ci serve per definire una "collezione" di endpoints
// Ogni endpoint sarà un metodo di questa classe)
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    BlogPostService blogPostService;

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getAuthorList(){
        System.out.println("getAuthorList");
        return this.authorService.gettAuthorList();
    }
    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return this.authorService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public Author saveAuthor(@RequestBody Author body) {
        return this.authorService.saveAuthor(body);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        this.authorService.findByIdAndDelete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Author updateAuthor(@PathVariable int id,@RequestBody Author updatedAuthor) {
        return this.authorService.findByIdAndUpdate(id, updatedAuthor);
    }
}
