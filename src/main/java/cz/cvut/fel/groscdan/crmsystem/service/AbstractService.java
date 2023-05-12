package cz.cvut.fel.groscdan.crmsystem.service;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T extends JpaRepository<E, Long>, E extends AbstractEntity> {


    protected final T repository;
    private final String name;

    public AbstractService(T repository, String name) {
        this.repository = repository;
        this.name = name;
    }

    public List<E> create(List<E> records) {
        List<E> createdRecords = new ArrayList<>();
        for (E record : records) {
            record.setDeleted(false);
            record.setCreated(LocalDateTime.now());
            record.setModified(LocalDateTime.now());
            createdRecords.add(repository.saveAndFlush(record));
        }
        return createdRecords;
    }

    public E create(E record) {
        record.setDeleted(false);
        record.setCreated(LocalDateTime.now());
        record.setModified(LocalDateTime.now());
        return repository.saveAndFlush(record);
    }

    public List<E> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Transactional
    public E update(E record) {
        if (!repository.existsById(record.getId())) {
            return create(record);
        }
        E existingRecord = repository.findById(record.getId()).get();
        existingRecord.setModified(LocalDateTime.now());
        return updateExisting(existingRecord, record);
    }

    public E getOneById(Long id) {
        E entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity " + name + " with " + id + " not found."));
        if (entity.getDeleted()) {
            throw new EntityNotFoundException("Entity " + name + " with " + id + " not found.");
        }
        return entity;
    }

    public E getOneById(Long id, RuntimeException runtimeException) {
        E entity = repository.findById(id).orElseThrow(() -> runtimeException);
        if (entity.getDeleted()) {
            throw new EntityNotFoundException("Entity " + name + " with " + id + " not found.");
        }
        return entity;
    }

    public void delete(Long id) throws DeleteError {
        E entity = getOneById(id, new DeleteError());
        entity.setDeleted(true);
        repository.saveAndFlush(entity);
    }

    protected abstract E updateExisting(E existingRecord, E record);

}
