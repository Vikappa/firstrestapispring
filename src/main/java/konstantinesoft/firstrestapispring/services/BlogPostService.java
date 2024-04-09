package konstantinesoft.firstrestapispring.services;
import konstantinesoft.firstrestapispring.entities.BlogPost;
import konstantinesoft.firstrestapispring.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
// Un service è  un componente di un'applicazione Spring Boot che gestisce un elenco di utenti, in questo caso serve da DATABASE fittizio
    private List<BlogPost> allPosts = new ArrayList<>();

    public List<BlogPost> getAllPosts(){
        return this.allPosts;
    }

    public BlogPost savePost(BlogPost body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
        this.allPosts.add(body);
        return body;
    }

    public BlogPost findById(int id){
        BlogPost found = null;
        for(BlogPost user: this.allPosts){
            if(user.getId() == id) found = user;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public String findByIdAndReplace(int id, BlogPost newBody){
        int index = -1;
        for(int i = 0; i < this.allPosts.size(); i++){
            if(this.allPosts.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            newBody.setId(id);
            this.allPosts.set(index, newBody);
            return newBody.toString();
        } else {
            throw new NotFoundException(id);
        }
    }


    public BlogPost findByIdAndUpdateCategory(int id, String newcategory){
        BlogPost found = null;
        for(BlogPost post: this.allPosts){
            if(post.getId() == id) {
                found = post;
                found.setCategoria(newcategory);
            }

        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }
    public BlogPost findByIdAndUpdateCover(int id, String newCover){
        BlogPost found = null;
        for(BlogPost post: this.allPosts){
            if(post.getId() == id) {
                found = post;
                found.setCover(newCover);
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public BlogPost findByIdAndUpdateContenuto(int id, String contenuto){
        BlogPost found = null;
        for(BlogPost post: this.allPosts){
            if(post.getId() == id) {
                found = post;
                found.setContenuto(contenuto);
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public String deleteById(int id) {
        Iterator<BlogPost> iterator = this.allPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost post = iterator.next();
            if (post.getId() == id) {
                iterator.remove();
                return post.toString();
            }
        }
        return "BlogPost non trovato";
    }

}
