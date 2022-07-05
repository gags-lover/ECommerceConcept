package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.models.ProductDetailsLocalDto

@Dao
interface DetailsScreenDao {

    @Insert(entity = ProductDetailsLocalDto::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveProductDetails(details: ProductDetailsLocalDto)

    @Query("SELECT * FROM product_details_table")
    fun getProductDetails(): ProductDetailsLocalDto
}