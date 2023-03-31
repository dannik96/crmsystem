package cz.cvut.fel.groscdan.crmsystem.service;

import cz.cvut.fel.groscdan.crmsystem.controller.exception.DeleteError;
import cz.cvut.fel.groscdan.crmsystem.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T extends JpaRepository<E, Long>, E extends AbstractEntity> {


    protected final T repository;

    public AbstractService(T repository) {
        this.repository = repository;
    }


    public E create(E record) {
        record.setCreated(LocalDateTime.now());
        record.setModified(LocalDateTime.now());
        return repository.saveAndFlush(record);
    }

    public List<E> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    public E update(E record) {
        if (!repository.existsById(record.getId())) {
            return create(record);
        }
        E existingRecord = repository.getReferenceById(record.getId());
        existingRecord.setModified(LocalDateTime.now());
        return updateExisting(existingRecord, record);
    }

    public E getOneById(Long id){
        return repository.getReferenceById(id);
    }

    public boolean delete(Long id) throws DeleteError {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        throw new DeleteError();
    }

    protected abstract E updateExisting(E existingRecord, E record);

}
