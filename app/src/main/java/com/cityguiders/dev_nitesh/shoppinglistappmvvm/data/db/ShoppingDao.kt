package com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.entity.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

}