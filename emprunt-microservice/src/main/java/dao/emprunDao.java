package dao;


import Model.Emprunt;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Repository
public class emprunDao implements JpaRepository<Emprunt, Integer> {
    @Override
    public void flush() {
    }

    @Override
    public <S extends Emprunt> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Emprunt> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Emprunt> entities) {

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
    public Emprunt getOne(Integer integer) {
        return null;
    }

    /**
     * @param integer
     * @deprecated
     */
    @Override
    public Emprunt getById(Integer integer) {
        return null;
    }

    @Override
    public Emprunt getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Emprunt> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Emprunt> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Emprunt> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Emprunt> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Emprunt> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Emprunt> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Emprunt, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Emprunt> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Emprunt> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Emprunt> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Emprunt> findAll() {
        return null;
    }

    @Override
    public List<Emprunt> findAllById(Iterable<Integer> integers) {
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
    public void delete(Emprunt entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Emprunt> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Emprunt> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Emprunt> findAll(Pageable pageable) {
        return null;
    }

}
