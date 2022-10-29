package com.myapdb.myapdb.ui.list.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.myapdb.myapdb.databinding.ItemConceptBinding

class ConceptListAdapter (

    private val conceptClickListener: (String) -> Unit
): ListAdapter<String, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding = ItemConceptBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolderList(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolderList -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolderList(private val binding: ItemConceptBinding) : BaseListViewHolder<String>(binding.root) {

        override fun bind(item: String, position: Int) = with(binding) {

            tvConceptName.text = item
            clParent.setOnClickListener { conceptClickListener(item) }
        }
    }

}