package com.hadirahimi.zoomablerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.hadirahimi.zoomablerecyclerview.databinding.ItemHouseBinding
import com.hadirahimi.zoomablerecyclerview.model.ModelHouse

class AdapterHouse : RecyclerView.Adapter<AdapterHouse.MyViewHolder>()
{
    private lateinit var binding : ItemHouseBinding
    private var list = emptyList<ModelHouse>()
    
    inner class MyViewHolder:RecyclerView.ViewHolder(binding.root)
    {
        fun setData(house:ModelHouse)
        {
            binding.apply {
                itemTitle.text = house.title
                itemAddress.text = house.address
                itemDistance.text = house.Distance
                itemImage.setImageResource(house.imageSource)
            }
        }
    }
    
    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : MyViewHolder
    {
        binding = ItemHouseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder()
    }
    
    override fun getItemCount() : Int = list.size
    
    override fun getItemViewType(position : Int) : Int
    {
        return position
    }
    
    override fun onBindViewHolder(holder : MyViewHolder , position : Int)
    {
        holder.setData(list[position])
    }
    
    fun submitData(houseList:List<ModelHouse>)
    {
        val houseDiffUtil = HouseDiffUtils(list,houseList)
        val diffUtils = DiffUtil.calculateDiff(houseDiffUtil)
        list = houseList
        diffUtils.dispatchUpdatesTo(this)
    }
    class HouseDiffUtils(
        private val oldList:List<ModelHouse>,
        private val newList:List<ModelHouse>
    ):DiffUtil.Callback()
    {
        override fun getOldListSize() : Int
        {
            return oldList.size
        }
    
        override fun getNewListSize() : Int
        {
            return newList.size
        }
    
        override fun areItemsTheSame(oldItemPosition : Int , newItemPosition : Int) : Boolean
        {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }
    
        override fun areContentsTheSame(oldItemPosition : Int , newItemPosition : Int) : Boolean
        {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
    }
}








