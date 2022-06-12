package ru.zinoview.coreuimodule

import android.view.ViewGroup

interface Adapter<T : UiModel> {

    abstract class Base<T : UiModel, E : Same<T>>(
        callback: BaseDiffUtilCallback<T,E>,
        private val itemToIntViewTypeMapper: ItemToIntViewTypeMapper<T>,
        private val intViewTypeMapper: IntViewTypeToViewHolderMapper<T>
    ) : androidx.recyclerview.widget.ListAdapter<E,BaseViewHolder<T>>(callback) {

        override fun getItemViewType(position: Int)
            = itemToIntViewTypeMapper.map(getItem(position) as T)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = intViewTypeMapper.map(Pair(parent,viewType))

        override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int)
            = holder.bind(getItem(position) as T)
    }
}