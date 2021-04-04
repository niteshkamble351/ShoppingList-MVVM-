package com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.entity.ShoppingItem
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }


    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItem()
}