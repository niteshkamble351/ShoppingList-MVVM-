package com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList

import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonCLick(item: ShoppingItem)
}