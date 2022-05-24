package com.example.booknumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.booknumber.databinding.ActivityMainBinding
import com.example.booknumber.roomdb.BookNumberDAO
import com.example.booknumber.roomdb.BookNumberEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

//import com.example.booknumber.roomdb.BookNumberRepo

class MainActivity : AppCompatActivity(), IBusinessLogic {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val bookNumberDAO = (application as BookNumberApp).db.bookNumberDao()

        binding?.saveBTN?.setOnClickListener {
            insertData(bookNumberDAO)
        }
        binding?.searchBTN?.setOnClickListener {
            searchNumber(bookNumberDAO)
        }
    }

    //First Business logic method
    override fun insertData(bookNumberDAO: BookNumberDAO) {
        val name = binding?.nameET?.text.toString()
        val number = binding?.numberET?.text.toString()
        try {
            if (name.isEmpty()) {
                binding?.nameET?.error = getString(R.string.nameError)
            } else if (number.isEmpty()) {
                binding?.numberET?.error = getString(R.string.numberError)
            } else {
                lifecycleScope.launch {
                    RoomDbImp(bookNumberDAO).insert(BookNumberEntity(name = name, number = number))
                    showMessage("Inserted Successfully")
                    binding?.nameET?.text?.clear()
                    binding?.numberET?.text?.clear()
                }
            }
        } catch (e: Exception) {
            showMessage("Failed")
        }

    }

    //2nd business logic method
    override fun searchNumber(bookNumberDAO: BookNumberDAO) {
        val searchName = binding?.nameSearchET?.text.toString()
        if (searchName.isEmpty()) {
            binding?.nameSearchET?.error = getString(R.string.nameError)
        } else {
            lifecycleScope.launch {
                try {
                    RoomDbImp(bookNumberDAO).getByNumber(searchName).collect() {
                        binding?.searchResult?.text = it.number
                    }
                    showMessage("Found!!")
                } catch (e: Exception) {
                    showMessage("Not Found")
                }
            }
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    //3rd business logic method


}