package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.AbstractState;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import cz.cvut.fel.groscdan.crmsystem.service.channel.PostStateService;
import org.springframework.stereotype.Service;

@Service
public class PostService extends AbstractService<PostRepository, Post> {
    private final PostStateService postStateService;

    public PostService(PostRepository postRepository, PostStateService postStateService) {
        super(postRepository, "Post");
        //this.postRepository = postRepository;
        this.postStateService = postStateService;
    }

    @Override
    protected Post updateExisting(Post existingRecord, Post record) {
        existingRecord.setName(record.getName());
        existingRecord.setContent(record.getContent());
        existingRecord.setPostDate(record.getPostDate());

        return repository.saveAndFlush(existingRecord);
    }

    public void setState(Long postId, Long stateId) {
        Post post = getOneById(postId, new PatchError());
        PostState state = postStateService.getOneById(stateId, new PatchError());

        post.setPostState(state);

        repository.saveAndFlush(post);
    }
}
