package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostStateRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostStateService extends AbstractService<PostStateRepository, PostState> {

    private final PostRepository postRepository;

    public PostStateService(PostStateRepository repository, PostRepository postRepository) {
        super(repository, "PostState");
        this.postRepository = postRepository;
    }

    @Override
    public void delete(Long id) throws DeleteError {
        PostState postState = getOneById(id, new DeleteError());
        List<Post> posts = postRepository.findByPostState(postState);
        posts.forEach(post -> {
            post.setPostState(null);
            postRepository.saveAndFlush(post);
        });
        repository.delete(postState);
    }

    @Override
    protected PostState updateExisting(PostState existingRecord, PostState record) {
        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());
        return null;
    }
}
