package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.models.cart.CartMainScreenLocalDto
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.models.main_page.MainPageLocalDto

@Dao
interface MainScreenDao {

    @Insert(entity = MainPageLocalDto::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveMainPage(mainPage: MainPageLocalDto)

    @Query("SELECT * FROM main_page_table")
    fun getMainPage(): MainPageLocalDto

    @Insert(entity = CartMainScreenLocalDto::class, onConflict = OnConflictStrategy.REPLACE)
    fun saveCart(cart: CartMainScreenLocalDto)

    @Query("SELECT * FROM cart_items_count_table")
    fun getCart(): CartMainScreenLocalDto
}