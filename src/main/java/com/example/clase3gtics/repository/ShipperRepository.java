package com.example.clase3gtics.repository;

import com.example.clase3gtics.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

    List<Shipper> findByCompanyName(String name);

    List<Shipper> findByCompanyNameOrPhone(String n, String p);

    @Query(nativeQuery = true,value = "select * from shippers where CompanyName = ?1")
    List<Shipper> buscarPorNombre(String nombre);

    @Query(nativeQuery = true, value = "select * from shippers where CompanyName like %?1%")
    List<Shipper> buscarParcialPorNombre(String nombre);

}

