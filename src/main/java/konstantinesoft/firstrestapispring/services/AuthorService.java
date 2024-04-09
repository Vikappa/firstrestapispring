package konstantinesoft.firstrestapispring.services;

import jakarta.websocket.server.PathParam;
import konstantinesoft.firstrestapispring.entities.Author;
import konstantinesoft.firstrestapispring.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    // Un service è  un componente di un'applicazione Spring Boot che gestisce un elenco di utenti, in questo caso serve da DATABASE fittizio

    private List<Author> authorList = new ArrayList<>();

    public List<Author> gettAuthorList(){
        return this.authorList;
    }

    public Author saveAuthor(Author body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
        this.authorList.add(body);
        return body;
    }

    public Author findById(int id){
        Author found = null;
        for(Author auth: this.authorList){
            if(auth.getId() == id) found = auth;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }


    public Author findByIdAndUpdate(int id, Author updatedAuthor){
        Author found = null;
        for(Author auth: this.authorList){
            if(auth.getId() == id) {
                found = auth;
                found.setNome(updatedAuthor.getNome());
                found.setCognome(updatedAuthor.getCognome());
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<Author> iterator = this.authorList.iterator();

        while(iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }

    }
}