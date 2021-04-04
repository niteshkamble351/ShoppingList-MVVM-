package com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.R
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.ShoppingDatabase
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.db.entity.ShoppingItem
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.data.repositories.ShoppingRepository
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.other.ShoppingItemAdapter
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList.AddDialogListener
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList.AddShoppingItemDialog
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList.ShoppingViewModel
import com.cityguiders.dev_nitesh.shoppinglistappmvvm.ui.shoppingList.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItem.layoutManager = LinearLayoutManager(this)
        rvShoppingItem.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonCLick(item: ShoppingItem) {
                    viewModel.upsert(item)

                }
            }).show()
        }

    }
}