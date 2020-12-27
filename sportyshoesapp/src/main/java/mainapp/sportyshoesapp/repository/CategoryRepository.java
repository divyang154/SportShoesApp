package mainapp.sportyshoesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import mainapp.sportyshoesapp.model.Category;;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
