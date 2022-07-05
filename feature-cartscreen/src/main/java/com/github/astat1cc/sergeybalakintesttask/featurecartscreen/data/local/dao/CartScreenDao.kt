package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.models.CartLocalDto

@Dao
interface CartScreenDao {

    @Insert(entity = CartLocalDto::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveCart(cart: CartLocalDto)

    @Query("SELECT * FROM cart_table")
    fun getCart(): CartLocalDto
}