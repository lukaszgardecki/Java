package com.example.zad_10_jpa_klasyencji;

import jakarta.persistence.EntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface BikeRepository extends CrudRepository<Bike, Long> {
//      typ_zwracany nazwa
//      temat np. deleteByName(String user)

    Optional<Bike> findBySerialNoIgnoreCase(String serialNo);
    int countAllByBorrowerIdIsNotNull();
    List<Bike> findAllByBorrowerIdIsNullOrderByDayPrice();




//    private final EntityManager entityManager;
//
//    public BikeRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    // metody oznaczone @Transactional MUSZĄ być publiczne
//    public void save(Bike bike) {
//        entityManager.persist(bike);
//    }
//
//    public Optional<Bike> findById(Long id) {
//        return Optional.ofNullable(entityManager.find(Bike.class, id));
//    }
//
//
//    public void deleteById(Long id) {
//        findById(id).ifPresent(entityManager::remove);
//    }
//
////    @Transactional
////    public void delete(Bike bike) {
////        Bike mergedEntity = entityManager.merge(bike);
////        entityManager.refresh(mergedEntity);
////    }
}
