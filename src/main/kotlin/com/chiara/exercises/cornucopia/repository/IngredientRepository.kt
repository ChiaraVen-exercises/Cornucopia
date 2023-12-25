package com.chiara.exercises.cornucopia.repository

import com.chiara.exercises.cornucopia.entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

// If you wish to change the default path of your auto-generated REST controller, use the annotation below:
// @RepositoryRestResource(path = "ingrydients")
interface IngredientRepository : JpaRepository<Ingredient, Long> {

    @Query("SELECT * FROM ingredients where name LIKE %?1%", nativeQuery = true)
    fun getIngredientsWithNameContaining(@Param("name") name : String) : Iterable<Ingredient>

    @Query("SELECT * FROM ingredients where name = ?1", nativeQuery = true)
    fun getIngredientByExactName(@Param("name") name : String) : Iterable<Ingredient>

//    deprecated, since we now rely on Spring Data REST for sorting.
//    add 'desc' after 'name' in the following line to sort the ingredients in descending order by name
//    @Query("SELECT * FROM ingredients order by name", nativeQuery = true)
//    fun getAllIngredientsSortedByNameAsc() : Iterable<Ingredient>

    /* A particular CRUD method can be disabled for a given entity in the following way...
    Actually, it should. Not working now, it seems...
     */
//    @Override
//    @RestResource(exported = false)
//    override fun deleteById(id : Long)

}
