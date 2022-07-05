package com.github.astat1cc.sergeybalakintesttask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.converters.BasketConverter
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.dao.CartScreenDao
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.models.CartLocalDto
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.converters.ProductDetailsConverter
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.dao.DetailsScreenDao
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.models.ProductDetailsLocalDto
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.converters.BestSellersConverter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.converters.HotSalesConverter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.dao.MainScreenDao
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.models.cart.CartMainScreenLocalDto
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.models.main_page.MainPageLocalDto

@Database(
    entities = [MainPageLocalDto::class, CartMainScreenLocalDto::class, ProductDetailsLocalDto::class, CartLocalDto::class],
    version = 1
)
@TypeConverters(
    BestSellersConverter::class,
    HotSalesConverter::class,
    ProductDetailsConverter::class,
    BasketConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mainScreenDao(): MainScreenDao

    abstract fun detailsScreenDao(): DetailsScreenDao

    abstract fun cartScreenDao(): CartScreenDao
}