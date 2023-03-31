package cz.cvut.fel.groscdan.crmsystem.service;

import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService extends AbstractService<PostRepository, Post>{
    //private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        super(postRepository);
        //this.postRepository = postRepository;
    }

    @Override
    protected Post updateExisting(Post existingRecord, Post record) {
        // TODO
        return null;
    }

}
