package com.hadirahimi.zoomablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.hadirahimi.zoomablerecyclerview.databinding.ActivityMainBinding
import com.hadirahimi.zoomablerecyclerview.model.ModelHouse

class MainActivity : AppCompatActivity()
{
    //binding
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapterHouse : AdapterHouse
    
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //InitViews
        binding.apply {
            adapterHouse = AdapterHouse()
            adapterHouse.submitData(getList())
            recyclerview.apply {
                layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
                adapter = adapterHouse
            }
        }
    }
    private fun getList() : List<ModelHouse>{
        val list = ArrayList<ModelHouse>()
        list.add(ModelHouse(1,"Apartment X","48 Chester Torquey , Road","5.1Km away",R.drawable.one))
        list.add(ModelHouse(2,"Villa Savoye","774 Bellvue Street, Normandy","1.13Km away",R.drawable.two))
        list.add(ModelHouse(3,"Apartment Y","23 Chester Road , Torquey","24.3Km away",R.drawable.three))
        list.add(ModelHouse(4,"cute Apartment","251 Normandy Street, Bellvue","8.2Km away",R.drawable.four))
        return list
    }
}










