package ru.zinoview.coreuimodule

import android.view.LayoutInflater
import android.view.ViewGroup

interface Adapter<T : UiModel> {

    fun update(data: List<T>)

    abstract class Base<T : UiModel, E : Same<T>>(
        callback: BaseDiffUtilCallback<T,E>,
        private val viewHolderByViewType: ViewHolderByViewType<T>
    ) : androidx.recyclerview.widget.ListAdapter<E,BaseViewHolder<T>>(callback), Adapter<T> {

        override fun update(data: List<T>) {
            val list = data.map { item -> item as E }
            submitList(list)
        }

        override fun getItemViewType(position: Int)
            = viewHolderByViewType.viewType(getItem(position) as T)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = viewHolderByViewType.viewHolder(viewType,LayoutInflater.from(parent.context),parent)

        override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int)
            = holder.bind(getItem(position) as T)
    }
}