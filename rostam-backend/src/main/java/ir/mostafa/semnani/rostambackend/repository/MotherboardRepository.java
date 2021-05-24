package ir.mostafa.semnani.rostambackend.repository;


import ir.mostafa.semnani.rostambackend.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard , Long> {

}
