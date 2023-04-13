package dao;

import model.Livre;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class livreDao implements JpaRepository<Livre, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Livre> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Livre> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Livre> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Livre getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Livre getById(Integer integer) {
        return null;
    }

    @Override
    public Livre getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Livre> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Livre> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Livre> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Livre> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Livre> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Livre> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Livre, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Livre> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Livre> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Livre> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Livre> findAll() {
        return null;
    }

    @Override
    public List<Livre> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Livre entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Livre> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Livre> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Livre> findAll(Pageable pageable) {
        return null;
    }
}
