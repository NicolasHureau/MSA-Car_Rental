package fr.campusnumerique.vehicle.dao;

import fr.campusnumerique.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

    @Query(value = "SELECT * FROM vehicle v WHERE v.id NOT IN (SELECT vehicle_id FROM reservation r WHERE r.rental_end > :startDate AND r.rental_start < :endDate )", nativeQuery = true)
    Collection<Vehicle> findAvailability(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

//    Collection<Vehicle> findByBrand(String brand);
//
//    Collection<Vehicle> findByType(String type);
//
//    Collection<Vehicle> findByBrandAndType(String brand, String type);
//
//    Collection<Vehicle> findByFiscalHp(Integer fiscalHp);
//
//    Collection<Vehicle> findByColor(String color);
//
//    Collection<Vehicle> findByBrandAndTypeAndColorAndFiscalHp(String brand, String type, String color, Integer fiscalHp);

//    Collection<Vehicle> findByType(String type);
}




