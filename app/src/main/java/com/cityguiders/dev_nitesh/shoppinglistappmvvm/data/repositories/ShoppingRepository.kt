package com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.repositories

import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.ShoppingDatabase
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.entity.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItems()

}