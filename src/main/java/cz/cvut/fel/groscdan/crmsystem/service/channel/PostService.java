package cz.cvut.fel.groscdan.crmsystem.service.channel;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.PatchError;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Channel;
import cz.cvut.fel.groscdan.crmsystem.model.channel.Post;
import cz.cvut.fel.groscdan.crmsystem.model.channel.PostState;
import cz.cvut.fel.groscdan.crmsystem.repository.channel.PostRepository;
import cz.cvut.fel.groscdan.crmsystem.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PostService extends AbstractService<PostRepository, Post> {
    private final PostStateService postStateService;
    private final ChannelService channelService;

    public PostService(PostRepository postRepository, PostStateService postStateService, ChannelService channelService) {
        super(postRepository, "Post");
        //this.postRepository = postRepository;
        this.postStateService = postStateService;
        this.channelService = channelService;
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

    public void addChannel(Long postId, Long channelId) {
        Post post = getOneById(postId, new PatchError());
        Channel channel = channelService.getOneById(channelId, new PatchError());

        post.addChannel(channel);

        repository.saveAndFlush(post);
    }

    public void removeChannel(Long postId, Long channelId) {
        Post post = getOneById(postId, new PatchError());
        Channel channel = channelService.getOneById(channelId, new PatchError());

        post.removeChannel(channel);

        repository.saveAndFlush(post);
    }
}
